package de.eightbitboy.jenot

import com.typesafe.config.Config

import static com.google.common.truth.Truth.assertThat

class Jenot {
    public static void main(String... args) {
        println 'Hello world!'

        Properties properties = new Properties()
        File propertiesFile = new File('jenot.properties')
        propertiesFile.withInputStream {
            properties.load(it)
        }

        println 'properties:'
        println properties

        Config config = Configuration.getInstance().getConfig()

        println 'config:'
        println config

        assertThat(properties['server']).named('server').isNotNull()

        //new Ui()
        //new Notification("Hello world!")
        Jenkins jenkins = new Jenkins(properties['server'])
    }
}
