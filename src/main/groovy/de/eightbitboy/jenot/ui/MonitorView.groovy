package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import java.awt.*
import java.util.List

class MonitorView extends JFrame {
    private List<JobStatusView> statuses = []

    JPanel content

    MonitorView(Map<String, JobWithDetails> jobs) {
        super('MonitorView')

        this.content = new JPanel(new GridLayout(5, 1));

        jobs.each { name, job ->
            println 'Adding job' + name

            def status = new JobStatusView(job)
            statuses.add(status)
            addStatus(status)
        }


        setSize(600, 400)
        add(this.content)
        pack()
        setVisible(true)
    }

    private void addStatus(JobStatusView status) {
        this.content.add(status)
    }

    void refresh(){

    }
}
