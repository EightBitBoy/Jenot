package de.eightbitboy.jenot.ui

import javax.swing.ImageIcon
import javax.swing.UIManager
import java.awt.MenuItem
import java.awt.PopupMenu
import java.awt.SystemTray
import java.awt.TrayIcon

class Ui {
    public Ui(){
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

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
}
