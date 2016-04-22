package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.BuildWithDetails
import com.offbytwo.jenkins.model.Job
import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {

    private Job job

    private JLabel jobNameLabel
    private JLabel buildStatusLabel
    private JLabel buildNumberLabel
    private JProgressBar progressBar

    JobStatusView(Job job) {
        this.job = job
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
        setBorder(new LineBorder(Color.BLACK))

        setUpTop()
        setUpBottom()
    }

    private setUpTop() {
        JPanel top = new JPanel(new GridLayout(1, 3))

        this.jobNameLabel = new JLabel(job.getName())
        this.buildStatusLabel = new JLabel()
        this.buildNumberLabel = new JLabel()

        top.add(this.jobNameLabel)
        top.add(this.buildStatusLabel)
        top.add(this.buildNumberLabel)

        add(top)
    }

    private setUpBottom() {
        JPanel bottom = new JPanel(new GridLayout(1, 1))

        this.progressBar = new JProgressBar()

        bottom.add(this.progressBar)

        add(bottom)
    }

    void refresh() {
        JobWithDetails jobDetails = this.job.details()
        BuildWithDetails buildDetails = jobDetails.getLastBuild().details()

        int lastBuildNumber = buildDetails.getNumber()
        this.buildNumberLabel.setText(lastBuildNumber as String)

        if (buildDetails.isBuilding()) {
            this.buildStatusLabel.setText('BUILDING')
        } else {
            this.buildStatusLabel.setText(buildDetails.getResult() as String)
        }

        if (buildDetails.isBuilding()) {
            long buildTime = new Date().getTime() - buildDetails.getTimestamp()

            this.progressBar.setMinimum(0)
            this.progressBar.setMaximum(buildDetails.getEstimatedDuration())
            this.progressBar.setValue(buildTime as Integer)
        }
    }
}
