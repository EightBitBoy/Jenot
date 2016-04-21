package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import java.awt.*
import java.util.List

class Monitor extends JFrame {
    private List<JobStatus> statuses = []

    JPanel content

    Monitor(Map<String, JobWithDetails> jobs) {
        super('Monitor')

        this.content = new JPanel(new GridLayout(5, 1));

        this.content.add(new JLabel("foo"))

        jobs.each { name, job ->
            println 'Adding job' + name

            def status = new JobStatus(job)

            statuses.add(status)
            addStatus(status)
        }


        setSize(600, 400)
        add(this.content)
        pack()
        setVisible(true)
        //watch()
    }

    private void addStatus(JobStatus status) {
        this.content.add(status)
    }

    private void watch() {
        //TODO use some mechanism provided by swing
        while (true) {
            sleep(2000)
            println 'Refresh'
        }
    }
}
