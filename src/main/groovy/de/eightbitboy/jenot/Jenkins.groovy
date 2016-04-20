package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.Job

import static com.google.common.truth.Truth.assertThat

class Jenkins {
    JenkinsServer server

    Jenkins(String url) {
        this.server = new JenkinsServer(new URI(url))
        Map<String, Job> jobs = this.server.getJobs()

        assertThat(jobs).named('jobs').isNotNull()




        println jobs

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
}
