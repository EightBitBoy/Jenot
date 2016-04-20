package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.Job

import static com.google.common.truth.Truth.assertThat

class Jenkins {
    JenkinsServer server

    Jenkins(String url) {
        connect(url)

        def allJobs = this.server.getJobs()
        assertThat(allJobs).named('allJobs').isNotNull()

        def jobs = loadsavedJobs()
        assertThat(jobs).named('jobs').isNotEmpty()

        /*
        JobWithDetails job = jenkins.getJob(properties.job as String)

        println job

        List<Build> builds = job.getBuilds()
        builds.each{
            println it.details().getDuration()
        }
        */
    }

    private void connect(String url) {
        try {
            this.server = new JenkinsServer(new URI(url))
        } catch (UnknownHostException ex) {
            ex.printStackTrace()
            //TODO
        }
        assertThat(this.server).named('server').isNotNull()
    }

    private Map<String, Job> loadsavedJobs() {
        def jobs = [:]

        new File('jobs.txt').eachLine { line ->
            println line
        }

        return jobs
    }
}
