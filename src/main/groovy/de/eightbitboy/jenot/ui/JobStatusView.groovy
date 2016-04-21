package de.eightbitboy.jenot.ui

import com.offbytwo.jenkins.model.JobWithDetails

import javax.swing.*
import javax.swing.border.LineBorder
import java.awt.Color
import java.awt.FlowLayout

class JobStatusView extends JPanel {
    JobStatusView(JobWithDetails job) {
        setLayout(new FlowLayout(4));
        for (int index = 0; index < 4; index++) {
            add(new JLabel(Integer.toString(index)));
        }
        setBorder(new LineBorder(Color.RED));
    }

    void update(JobWithDetails job) {

    }
}