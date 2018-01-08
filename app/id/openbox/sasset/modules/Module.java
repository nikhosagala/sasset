package id.openbox.sasset.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import id.openbox.sasset.data.BackgroundTask;


@Singleton
public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(BackgroundTask.class).asEagerSingleton();
    }
}
