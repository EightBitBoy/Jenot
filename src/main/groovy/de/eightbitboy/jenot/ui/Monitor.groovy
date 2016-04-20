package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*

class Monitor extends JFrame {
    private List<JobStatus> statuses = []

    Monitor(Map<String, JobWithDetails> jobs) {
        super('Monitor')

        jobs.each { name, job ->
            statuses.add(new JobStatus(job))
            println 'Adding job' + name
        }

        setSize(600, 400)
        setVisible(true)
        watch()
    }

    private void watch() {
        //TODO use some mechanism provided by swing
        while (true) {
            sleep(2000)
            println 'Refresh'
        }
    }
}
