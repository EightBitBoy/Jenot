package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*

class Monitor extends JFrame {
    private List<JobStatus> statuses = []

    Monitor(Map<String, JobWithDetails> jobs) {
        super('Monitor')

        jobs.each { name, job ->
            println 'Adding job' + name

            def status = new JobStatus(job)

            statuses.add(status)
            addStatus(status)
        }

        setSize(600, 400)
        setVisible(true)
        watch()
    }

    private void addStatus(JobStatus status) {
        getContentPane().add(status)
    }

    private void watch() {
        //TODO use some mechanism provided by swing
        while (true) {
            sleep(2000)
            println 'Refresh'
        }
    }
}
