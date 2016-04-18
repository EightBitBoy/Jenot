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

        SystemTray tray = SystemTray.getSystemTray();
        TrayIcon trayIcon = new TrayIcon(new ImageIcon("tray.png", "Icon").getImage())
        PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("About");
        popup.add(aboutItem)
        trayIcon.setPopupMenu(popup)
        tray.add(trayIcon)
    }
}
