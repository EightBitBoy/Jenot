package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.Build
import com.offbytwo.jenkins.model.Job
import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {

    private Job job

    private JLabel jobNameLabel
    private JLabel previousBuildLabel
    private JLabel buildNumberLabel

    JobStatusView(Job job) {
        this.job = job
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
        setBorder(new LineBorder(Color.RED))

        setUpTop()
        setUpBottom()
    }

    private setUpTop() {
        JPanel top = new JPanel(new GridLayout(1, 3))
        top.setBorder(new LineBorder(Color.GREEN))

        this.jobNameLabel = new JLabel(job.getName())
        this.previousBuildLabel = new JLabel()
        this.buildNumberLabel = new JLabel()

        top.add(this.jobNameLabel)
        top.add(this.previousBuildLabel)
        top.add(this.buildNumberLabel)

        add(top)
    }

    private setUpBottom() {
        JPanel bottom = new JPanel(new GridLayout(1, 1))
        bottom.setBorder(new LineBorder(Color.BLUE))
        bottom.add(new JLabel('Progress'))
        add(bottom)
    }

    void refresh() {
        JobWithDetails details = job.details()

        int lastBuildNumber = details.getLastBuild().getNumber()
        this.buildNumberLabel.setText(lastBuildNumber as String)

        //TODO take care of first build
        Build previousBuild = details.getBuildByNumber(lastBuildNumber - 1)
        if (previousBuild) {
            this.previousBuildLabel.setText(previousBuild.details().getResult().toString())
        }
    }
}
