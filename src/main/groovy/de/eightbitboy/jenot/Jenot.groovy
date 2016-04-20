package de.eightbitboy.jenot

import com.typesafe.config.Config

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
        /*
        JenkinsServer jenkins = new JenkinsServer(new URI(properties.server as String), properties.user as String, properties.password as String)
        JobWithDetails job = jenkins.getJob(properties.job as String)

        println job

        List<Build> builds = job.getBuilds()
        builds.each{
            println it.details().getDuration()
        }
        */

        //new Ui()
        //new Notification("Hello world!")
    }
}
