package id.co.telkom.fam.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import id.co.telkom.fam.data.BackgroundTask;


@Singleton
public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(BackgroundTask.class).asEagerSingleton();
    }
}
