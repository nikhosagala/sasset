package id.openbox.sasset.data;

import akka.actor.ActorSystem;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import play.Logger;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

@Singleton
public class BackgroundTask {

    private final ActorSystem actorSystem;
    private final ExecutionContext executionContext;

    @Inject
    public BackgroundTask(ActorSystem actorSystem, ExecutionContext executionContext) {
        this.actorSystem = actorSystem;
        this.executionContext = executionContext;
        this.initialize();
    }

    private void initialize() {
        this.actorSystem.scheduler().scheduleOnce(
                Duration.create(20, TimeUnit.SECONDS), // delay
                () -> {
                    Logger.info("Setting up your database from Excel");
                    MasterData.getInstance().createTREG(0);
                    MasterData.getInstance().createWITEL(1);
//                    MasterData.getInstance().createArea();
//                    MasterData.getInstance().createFMGsd();
                    MasterData.getInstance().createVendor(7);
                    MasterData.getInstance().createElectricityPAM(8); // Electricity
                    MasterData.getInstance().createElectricityPAMDetail(9); // Electricity Detail
                    MasterData.getInstance().createOffice(2);
                    MasterData.getInstance().createLocation(3);
                    MasterData.getInstance().createAssetType(4);
                    MasterData.getInstance().createAsset(5);
                    Logger.info("Finished setting up your database from Excel");
                },
                this.executionContext
        );
    }
}
