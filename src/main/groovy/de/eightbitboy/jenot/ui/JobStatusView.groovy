package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.BuildWithDetails
import com.offbytwo.jenkins.model.Job
import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {

    private Job job

    private JPanel top
    private JPanel bottom

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
        this.top = new JPanel(new GridLayout(1, 3))
        this.top.setOpaque(true)

        this.jobNameLabel = new JLabel(job.getName())
        this.buildStatusLabel = new JLabel()
        this.buildNumberLabel = new JLabel()

        this.top.add(this.jobNameLabel)
        this.top.add(this.buildStatusLabel)
        this.top.add(this.buildNumberLabel)

        add(this.top)
    }

    private setUpBottom() {
        this.bottom = new JPanel(new GridLayout(1, 1))
        this.bottom.setOpaque(true)

        this.progressBar = new JProgressBar()

        this.bottom.add(this.progressBar)

        add(this.bottom)
    }

    void refresh() {
        JobWithDetails jobDetails = this.job.details()
        BuildWithDetails buildDetails = jobDetails.getLastBuild().details()

        int lastBuildNumber = buildDetails.getNumber()
        this.buildNumberLabel.setText(lastBuildNumber as String)

        if (buildDetails.isBuilding()) {
            this.buildStatusLabel.setText('BUILDING')
            this.bottom.setBackground(Color.GRAY)
        } else {
            String result = buildDetails.getResult() as String
            this.buildStatusLabel.setText(result)

            if (result == 'SUCCESS') {
                this.top.setBackground(Color.GREEN)
                this.bottom.setBackground(Color.GREEN)
            }
            if (result == 'FAILURE') {
                this.top.setBackground(Color.RED)
                this.bottom.setBackground(Color.RED)
            }
        }

        if (buildDetails.isBuilding()) {
            long buildTime = new Date().getTime() - buildDetails.getTimestamp()
            this.progressBar.setEnabled(true)
            this.progressBar.setMinimum(0)
            this.progressBar.setMaximum(buildDetails.getEstimatedDuration())
            this.progressBar.setValue(buildTime as Integer)
        } else {
            this.progressBar.setEnabled(false)
            this.progressBar.setMinimum(0)
            this.progressBar.setMaximum(100)
            this.progressBar.setValue(100)
        }
    }
}
