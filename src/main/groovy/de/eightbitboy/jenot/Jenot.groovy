package de.eightbitboy.jenot

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.Build
import com.offbytwo.jenkins.model.JobWithDetails
import de.eightbitboy.jenot.ui.Notification

import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.UIManager
import java.awt.MenuItem
import java.awt.PopupMenu
import java.awt.SystemTray
import java.awt.TrayIcon

import com.typesafe.config.Config

class Jenot {
    public static void main(String... args) {
        println 'Hello world!'

        Properties properties = new Properties()
        /*
        File propertiesFile = new File('jenot.properties')
        propertiesFile.withInputStream {
            properties.load(it)
        }
        */

        println properties

        Config config = Configuration.getInstance().getConfig()

        println config
        /*
        JenkinsServer jenkins = new JenkinsServer(new URI(properties.server as String), properties.user as String, properties.password as String)
        JobWithDetails job = jenkins.getJob(properties.job as String)

        println job

        List<Build> builds = job.getBuilds()
        builds.each{
            println it.details().getDuration()
        }
        */


        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        /*
        JFrame frame = new JFrame("HelloWorldSwing");

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
        */

        /*
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
        */
        new Notification("Hello world!")
    }
}
