package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.JobWithDetails

import static com.google.common.truth.Truth.assertThat

class Jenkins {
    JenkinsServer server

    Jenkins(String url) {
        connect(url)

        def jobs = loadsavedJobs()
        assertThat(jobs).named('jobs').isNotEmpty()

        println jobs

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

    private Map<String, JobWithDetails> loadsavedJobs() {
        def jobs = [:]

        new File('jobs.txt').eachLine { jobLine ->
            //TODO handle exceptions
            def job = this.server.getJob(jobLine)
            assertThat(job).named('job').isNotNull()

            jobs.put(jobLine, job)
        }

        return jobs
    }
}
