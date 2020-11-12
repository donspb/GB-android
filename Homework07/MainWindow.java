package Homework07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainWindow extends JFrame {

    private final static int MAIN_WINDOW_HEIGHT = 600;
    private final static int MAIN_WINDOW_WIDTH = 600;

    private SettingsWindow settingsWindow;
    private GameMap gameMap;
    private HelpWindow helpWindow;

    MainWindow(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocation((int) screenSize.getWidth()/2 - MAIN_WINDOW_WIDTH/2, (int) screenSize.getHeight()/2 - MAIN_WINDOW_HEIGHT/2);
        setTitle("Tic-Tac-Toe");
        setResizable(false);

        settingsWindow = new SettingsWindow(this);
        gameMap = new GameMap();
        helpWindow = new HelpWindow(this);

        add(gameMap);

        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpWindow.setVisible(true);
            }
        });

        JButton btnClose = new JButton("Exit game");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnHelp);
        bottomPanel.add(btnClose);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {

        settingsWindow.setVisible(false);

        gameMap.startNewGame(mode,fieldSizeX,fieldSizeY,winLength);

    }


}
