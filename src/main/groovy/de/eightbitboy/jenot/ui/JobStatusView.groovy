package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {
    JobStatusView(JobWithDetails job) {
        setLayout(new FlowLayout(FlowLayout.LEFT))
        setBorder(new LineBorder(Color.RED))

        setUpTop(job)
        setUpBottom(job)
    }

    private setUpTop(JobWithDetails job) {
        JPanel top = new JPanel(new GridLayout(1, 1))
        top.setBorder(new LineBorder(Color.GREEN))
        top.add(new JLabel(job.getName()))
        add(top)
    }

    private setUpBottom(JobWithDetails job) {
        JPanel bottom = new JPanel(new GridLayout(1, 1))
        bottom.setBorder(new LineBorder(Color.BLUE))
        bottom.add(new JLabel('Progress'))
        add(bottom)
    }

    void update(JobWithDetails job) {

    }
}
