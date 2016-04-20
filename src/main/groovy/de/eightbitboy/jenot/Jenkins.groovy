package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.JobWithDetails

import static com.google.common.truth.Truth.assertThat

class Jenkins {
    JenkinsServer server
    private Map<String, JobWithDetails> userJobs

    Jenkins(String url) {
        connect(url)

        this.userJobs = loadSavedJobs()
        assertThat(userJobs).named('userJobs').isNotEmpty()
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

    private Map<String, JobWithDetails> loadSavedJobs() {
        def jobs = [:]

        new File('jobs.txt').eachLine { jobLine ->
            //TODO handle exceptions
            def job = this.server.getJob(jobLine)
            assertThat(job).named('job').isNotNull()

            jobs.put(jobLine, job)
        }

        return jobs
    }

    Map<String, JobWithDetails> getJobs() {
        return userJobs
    }
}
