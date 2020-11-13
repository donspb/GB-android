package Homework07;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int SET_WINDOW_HEIGHT = 300;
    private static final int SET_WINDOW_WIDTH = 300;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;

    private static final String FIELD_SIZE_PREFIX = "The field size is: ";
    private static final String WIN_LEN_PREFIX = "The win length is: ";

    private MainWindow mainWindow;

    private JRadioButton singlePlayer;
    private JRadioButton multiPlayer;
    private JSlider fieldSizeSelector;
    private JSlider winLenSelector;

    SettingsWindow(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        setSize(SET_WINDOW_WIDTH, SET_WINDOW_WIDTH);
        Rectangle mainWindowBounds = mainWindow.getBounds();
        int offsetX = (int) mainWindowBounds.getCenterX() - (SET_WINDOW_WIDTH/2);
        int offsetY = (int) mainWindowBounds.getCenterY() - (SET_WINDOW_HEIGHT/2);

        setLocation(offsetX, offsetY);
        setResizable(false);
        setTitle("Game settings");
        setLayout(new GridLayout(10,1));

        addModeSetup();
        addFieldSetup();

        JButton btnPlay = new JButton("Play!");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letsPlayClick();
            }
        });
        add(btnPlay);
        setVisible(false);


    }

    void addModeSetup() {

        add(new JLabel("Select game mode:"));
        singlePlayer = new JRadioButton("Single Player Mode", true);
        multiPlayer = new JRadioButton("Two Players Mode");
        ButtonGroup gameModeSelector = new ButtonGroup();
        gameModeSelector.add(singlePlayer);
        gameModeSelector.add(multiPlayer);
        add(singlePlayer);
        add(multiPlayer);

    }

    void addFieldSetup() {

        add(new JLabel("Select field size and win condition: \n\n"));

        JLabel fieldSetupLabel = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        add(fieldSetupLabel);
        fieldSizeSelector = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        fieldSizeSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = fieldSizeSelector.getValue();
                fieldSetupLabel.setText(FIELD_SIZE_PREFIX + currentValue);
                winLenSelector.setMaximum(currentValue);
            }
        });
        add(fieldSizeSelector);

        JLabel winLengthSetLabel = new JLabel(WIN_LEN_PREFIX + MIN_WIN_LENGTH);
        add(winLengthSetLabel);
        winLenSelector = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        winLenSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLengthSetLabel.setText(WIN_LEN_PREFIX + winLenSelector.getValue());
            }
        });
        add(winLenSelector);

    }

    private void letsPlayClick() {

        int gameMode;

        if (singlePlayer.isSelected()) {

            gameMode = GameMap.MODE_SINGLE;

        } else if (multiPlayer.isSelected()) {

            gameMode = GameMap.MODE_MULTI;

        } else {
            throw new RuntimeException("Wrong game mode!");
        }
        int fieldSize = fieldSizeSelector.getValue();
        int winLength = winLenSelector.getValue();

        mainWindow.startNewGame(gameMode,fieldSize,fieldSize,winLength);
    }
}
