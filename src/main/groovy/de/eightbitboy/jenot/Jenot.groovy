package de.eightbitboy.jenot

import com.typesafe.config.Config
import de.eightbitboy.jenot.ui.Ui

import static com.google.common.truth.Truth.assertThat

class Jenot {
    public static void main(String... args) {

        Properties properties = new Properties()
        File propertiesFile = new File('jenot.properties')
        propertiesFile.withInputStream {
            properties.load(it)
        }

        println 'properties:'
        println properties

        //TODO use this
        Config config = Configuration.getInstance().getConfig()

        println 'config:'
        println config

        assertThat(properties['server']).named('server').isNotNull()

        Jenkins jenkins = new Jenkins(properties['server'] as String)
        new Ui(jenkins)
        //new Notification("Hello world!")
    }
}
