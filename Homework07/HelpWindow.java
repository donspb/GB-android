package Homework07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;
    private static final int SHOW_RULES = 0;
    private static final int SHOW_ABOUT = 1;

    private MainWindow mainWindow;
    private JPanel contentPanel;
    private AboutPanel aboutPanel;
    private RulesPanel rulesPanel;

    HelpWindow (MainWindow mainWindow) {

        this.mainWindow = mainWindow;
        rulesPanel = new RulesPanel();
        aboutPanel = new AboutPanel();
        contentPanel = new JPanel();

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle mainWindowBounds = mainWindow.getBounds();
        int offsetX = (int) mainWindowBounds.getCenterX() - WINDOW_WIDTH/2;
        int offsetY = (int) mainWindowBounds.getCenterY() - WINDOW_HEIGHT/2;

        setLocation(offsetX, offsetY);
        setResizable(false);
        setTitle("Tic-Tac-Toe Help");

        showContent(SHOW_RULES);

        JButton btnRules = new JButton("Правила игры");
        JButton btnAbout = new JButton("О программе");

        btnRules.setEnabled(false);
        btnRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRules.setEnabled(false);
                btnAbout.setEnabled(true);
                showContent(SHOW_RULES);
            }
        });


        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRules.setEnabled(true);
                btnAbout.setEnabled(false);
                showContent(SHOW_ABOUT);
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(btnRules);
        buttonsPanel.add(btnAbout);
        add(buttonsPanel, BorderLayout.SOUTH);


        setVisible(false);
    }

    private void showContent(int showWhat) {

        contentPanel.removeAll();
        if (showWhat == SHOW_ABOUT) {
            contentPanel.add(aboutPanel);
            contentPanel.repaint();
            contentPanel.revalidate();
        }
        else if (showWhat == SHOW_RULES) {
            contentPanel.add(rulesPanel);
            contentPanel.repaint();
            contentPanel.revalidate();
        }

        add(contentPanel, BorderLayout.CENTER);

    }

}
