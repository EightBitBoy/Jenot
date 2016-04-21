package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import java.awt.*
import java.util.List

class MonitorView extends JFrame {
    private List<JobStatusView> statuses = []

    private JPanel content

    MonitorView(Map<String, JobWithDetails> jobs) {
        super('MonitorView')

        this.content = new JPanel(new GridLayout(jobs.size(), 1))
        add(this.content)

        addStatusViews(jobs)
        pack()
        setVisible(true)
    }

    private void addStatusViews(Map<String, JobWithDetails> jobs) {
        jobs.each { name, job ->
            println 'Adding job ' + name

            def view = new JobStatusView(job)
            statuses.add(view)
            this.content.add(view)
        }

    }

    void refresh() {
        //TODO
    }
}
