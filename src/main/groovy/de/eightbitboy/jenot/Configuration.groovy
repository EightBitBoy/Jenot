package de.eightbitboy.jenot

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

class Configuration {
    private static final class InstanceHolder {
        static final Configuration INSTANCE = new Configuration();
    }
    private Config config;

    private Config () {
        this.config = ConfigFactory.load()
    }

    public static Configuration getInstance () {
        return InstanceHolder.INSTANCE;
    }

    public getConfig(){
        return config;
    }
}
