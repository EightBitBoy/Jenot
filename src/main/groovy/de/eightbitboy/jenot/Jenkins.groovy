package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.Job

import static com.google.common.truth.Truth.assertThat

class Jenkins {
    JenkinsServer server

    Jenkins(String url) {
        this.server = new JenkinsServer(new URI(url))

        Map<String, Job> allJobs = this.server.getJobs()
        assertThat(allJobs).named('allJobs').isNotNull()

        Map<String, Job> jobs = loadsavedJobs()
        assertThat(jobs).named('jobs').isNotEmpty()

        //, properties.user as String, properties.password as String
        //this.server = new JenkinsServer(new URI(properties.server as String), properties.user as String, properties.password as String)
        /*
        JobWithDetails job = jenkins.getJob(properties.job as String)

        println job

        List<Build> builds = job.getBuilds()
        builds.each{
            println it.details().getDuration()
        }
        */
    }

    private Map<String, Job> loadsavedJobs() {
        Map<String, Job> jobs = [:]

        new File('jobs.txt').eachLine { line ->
            println line
        }

        return jobs
    }
}
