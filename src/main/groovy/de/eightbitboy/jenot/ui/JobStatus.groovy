package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*

class JobStatus extends JPanel {
    JobStatus(JobWithDetails job) {
        add(new JLabel(job.getName()))
        setVisible(true)
    }

    void update(JobWithDetails job) {

    }
}
