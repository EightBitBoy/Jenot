package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {

    private JobWithDetails job

    JobStatusView(JobWithDetails job) {
        this.job = job
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
        setBorder(new LineBorder(Color.RED))

        setUpTop()
        setUpBottom()
    }

    private setUpTop() {
        JPanel top = new JPanel(new GridLayout(1, 1))
        top.setBorder(new LineBorder(Color.GREEN))
        top.add(new JLabel(this.job.getName()))
        add(top)
    }

    private setUpBottom() {
        JPanel bottom = new JPanel(new GridLayout(1, 1))
        bottom.setBorder(new LineBorder(Color.BLUE))
        bottom.add(new JLabel('Progress'))
        add(bottom)
    }

    void update(JobWithDetails job) {

    }
}
