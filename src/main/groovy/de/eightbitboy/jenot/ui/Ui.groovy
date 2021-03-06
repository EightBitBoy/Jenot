package de.eightbitboy.jenot.ui

import de.eightbitboy.jenot.Jenkins

import javax.swing.*
import java.awt.*

class Ui {
    private Jenkins jenkins
    private MonitorView monitor

    Ui(Jenkins jenkins) {
        this.jenkins = jenkins

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        //TODO enable tray
        //setUpTray()
        setUpMonitor()
    }

    private void setUpTray() {

        if (!SystemTray.isSupported()) {
            println "No system tray!"
        }

        MenuItem aboutItem = new MenuItem("About");
        MenuItem exitItem = new MenuItem("Exit");

        PopupMenu popup = new PopupMenu();
        popup.add(aboutItem)
        popup.add(exitItem)

        TrayIcon trayIcon = new TrayIcon(new ImageIcon("tray.png", "Icon").getImage())
        trayIcon.setPopupMenu(popup)

        SystemTray tray = SystemTray.getSystemTray();
        tray.add(trayIcon)
    }

    private void setUpMonitor() {
        this.monitor = new MonitorView(jenkins.getUserJobs())
    }

    void watch() {
        //TODO find a better method
        while (true) {
            println 'Refreshing!'
            this.monitor.refresh()
            sleep(4000)
        }
    }
}
