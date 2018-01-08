package id.openbox.sasset.utils;

import com.google.inject.Provider;
import io.ebean.Ebean;
import io.ebean.EbeanServer;

public class EbeanServerProvider implements Provider<EbeanServer> {

    @Override
    public EbeanServer get() {

        // EbeanServer configured by ebean.properties
        return Ebean.getDefaultServer();
    }
}