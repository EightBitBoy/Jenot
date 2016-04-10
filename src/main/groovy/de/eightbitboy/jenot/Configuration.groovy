package de.eightbitboy.jenot

import com.typesafe.config.ConfigFactory

class Config {
    public static Config getConfig(){
    }
    private static final class InstanceHolder {
        static final Config INSTANCE = new Config();
    }
    private Config () {}

    public static Config getInstance () {
        return InstanceHolder.INSTANCE;
    }
}
