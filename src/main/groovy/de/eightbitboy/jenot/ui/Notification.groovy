package de.eightbitboy.jenot.ui

import javax.swing.*

class Notification {

    Notification(String message) {
        JFrame frame = new JFrame()
        frame.setSize(300, 200)

        JLabel messageLabel = new JLabel(message)
        frame.add(messageLabel)
        frame.setAlwaysOnTop(true)
        frame.setVisible(true)
    }
}
