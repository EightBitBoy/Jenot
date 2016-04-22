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
        this.previousBuildLabel = new JLabel()
        this.buildNumberLabel = new JLabel()

        top.add(this.jobNameLabel)
        top.add(this.previousBuildLabel)
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
        JobWithDetails details = job.details()
        Build lastBuild = details.getLastBuild()

        int lastBuildNumber = lastBuild.getNumber()
        this.buildNumberLabel.setText(lastBuildNumber as String)

        //TODO take care of first build
        Build previousBuild = details.getBuildByNumber(lastBuildNumber - 1)
        if (previousBuild) {
            this.previousBuildLabel.setText(previousBuild.details().getResult().toString())
        }

        
    }
}
