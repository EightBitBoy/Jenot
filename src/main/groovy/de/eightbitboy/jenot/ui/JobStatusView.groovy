package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.Build
import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.*

class JobStatusView extends JPanel {

    private JobWithDetails job

    private JLabel previousBuildLabel

    JobStatusView(JobWithDetails job) {
        this.job = job
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
        setBorder(new LineBorder(Color.RED))

        setUpTop()
        setUpBottom()
    }

    private setUpTop() {
        JPanel top = new JPanel(new GridLayout(1, 2))
        top.setBorder(new LineBorder(Color.GREEN))
        top.add(new JLabel(this.job.getName()))
        this.previousBuildLabel = new JLabel()
        top.add(this.previousBuildLabel)
        add(top)
    }

    private setUpBottom() {
        JPanel bottom = new JPanel(new GridLayout(1, 1))
        bottom.setBorder(new LineBorder(Color.BLUE))
        bottom.add(new JLabel('Progress'))
        add(bottom)
    }

    void refresh() {
        int lastBuildNumber = job.getLastBuild().getNumber()
        //TODO take care of first build
        Build previousBuild = job.getBuildByNumber(lastBuildNumber - 1)
        if (previousBuild) {
            this.previousBuildLabel.setText(previousBuild.details().getResult().toString())
        }
    }
}
