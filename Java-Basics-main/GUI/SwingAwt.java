package Java.GUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingAwt {
    public static void main(String[] args) {
        // AWT Example
        Frame awtFrame = new Frame("AWT Example");
        Button awtButton = new Button("AWT Button");
        awtFrame.add(awtButton);
        awtFrame.setSize(300, 100);
        awtFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        awtFrame.setVisible(true);

        // Swing Example
        JFrame swingFrame = new JFrame("Swing Example");
        JPanel swingPanel = new JPanel();
        JButton swingButton = new JButton("Swing Button");
        swingPanel.add(swingButton);
        swingFrame.add(swingPanel);
        swingFrame.setSize(300, 100);
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swingFrame.setVisible(true);
    }
}

