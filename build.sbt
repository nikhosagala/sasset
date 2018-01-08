
name := """sasset"""
organization := "id.co.wpl"

version := "0.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  ehcache,
  evolutions,
  guice,
  javaJdbc,
  "io.swagger" %% "swagger-play2" % "1.6.0",
  "org.apache.poi" % "poi" % "3.17",
  "org.apache.poi" % "poi-ooxml" % "3.17",
  "org.mindrot" % "jbcrypt" % "0.4",
  "org.webjars" % "swagger-ui" % "3.2.0",
  "org.postgresql" % "postgresql" % "42.1.4"
)

PlayKeys.devSettings := Seq("play.server.http.port" -> "9000")

val Success = 0 // 0 exit code
val Error = 1 // 1 exit code

PlayKeys.playRunHooks += baseDirectory.map(UIBuild.apply).value

val isWindows = System.getProperty("os.name").toLowerCase().contains("win")

def runScript(script: String)(implicit dir: File): Int = {
  if (isWindows) {
    Process("cmd /c " + script, dir)
  } else {
    Process(script, dir)
  }
} !

def uiWasInstalled(implicit dir: File): Boolean = (dir / "node_modules").exists()

def runNpmInstall(implicit dir: File): Int =
  if (uiWasInstalled) Success else runScript("npm install")

def ifUiInstalled(task: => Int)(implicit dir: File): Int =
  if (runNpmInstall == Success) task
  else Error

def runProdBuild(implicit dir: File): Int = ifUiInstalled(runScript("npm run build:play:prod"))

def runDevBuild(implicit dir: File): Int = ifUiInstalled(runScript("npm run build:play"))

def runUiTests(implicit dir: File): Int = ifUiInstalled(runScript("npm run test:play"))

lazy val `ui-dev-build` = TaskKey[Unit]("Run UI build when developing the application.")

`ui-dev-build` := {
  implicit val UIroot = baseDirectory.value / "ui"
  if (runDevBuild != Success) throw new Exception("Oops! UI Build crashed.")
}

lazy val `ui-prod-build` = TaskKey[Unit]("Run UI build when packaging the application.")

`ui-prod-build` := {
  implicit val UIroot = baseDirectory.value / "ui"
  if (runProdBuild != Success) throw new Exception("Oops! UI Build crashed.")
}

lazy val `ui-test` = TaskKey[Unit]("Run UI tests when testing application.")

`ui-test` := {
  implicit val UIroot = baseDirectory.value / "ui"
//  if (runUiTests != 0) throw new Exception("UI tests failed!")
}

//`ui-test` := (`ui-test` dependsOn `ui-dev-build`).value

dist := (dist dependsOn `ui-prod-build`).value

stage := (stage dependsOn `ui-prod-build`).value

test := ((test in Test) dependsOn `ui-test`).value


