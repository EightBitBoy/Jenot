package de.eightbitboy.jenot.ui

import javax.swing.JFrame
import javax.swing.JLabel

class Notification {

    public Notification(String message){
        JFrame frame = new JFrame();
        frame.setSize(300,125);

        JLabel messageLabel = new JLabel(message);
        frame.add(messageLabel);
        frame.setVisible(true);
    }
}
