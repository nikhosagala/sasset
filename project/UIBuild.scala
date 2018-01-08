import java.net.InetSocketAddress

import play.sbt.PlayRunHook
import sbt._

object UIBuild {
  def apply(base: File): PlayRunHook = {
    object UIBuildHook extends PlayRunHook {

      var process: Option[Process] = None

      var npmInstall: String = "npm install"
      var npmRun: String = "npm run build:play -- --watch"
      var delUi: String = "rm -rf ui"

      // Windows requires npm commands prefixed with cmd /c
      if (System.getProperty("os.name").toLowerCase().contains("win")) {
        npmInstall = "cmd /c" + npmInstall
        npmRun = "cmd /c" + npmRun
        delUi = "cmd /c rd /q /s ui"
      }

      override def beforeStarted(): Unit = {
        if (!(base / "ui" / "node_modules").exists()) Process(npmInstall, base / "ui").!
        if ((base / "public" / "ui").exists()) Process(delUi, base / "public").!
      }

      override def afterStarted(addr: InetSocketAddress): Unit = {
        process = Option(
          Process(npmRun, base / "ui").run
        )
      }

      override def afterStopped(): Unit = {
        process.foreach(_.destroy())
        process = Option(
          Process(delUi, base / "public").run
        )
      }

    }

    UIBuildHook
  }
}