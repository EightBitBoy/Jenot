package de.eightbitboy.jenot

import com.typesafe.config.Config
import de.eightbitboy.jenot.ui.Ui

import javax.swing.BoxLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

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

        /*
        JFrame main = new JFrame('Main')
        main.setSize(400, 400)

        JPanel container = new JPanel()
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS))

        container.add(new JLabel("Hello"))
        container.add(new JLabel("Again"))

        main.add(container)
        main.setVisible(true)
        */

        new Ui(jenkins)

        while (true) {
            sleep(4000)
            println 'Refresh'
        }
        //new Notification("Hello world!")
    }
}

class MyComponent {
    MyComponent() {

    }
}
