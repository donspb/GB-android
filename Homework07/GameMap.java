package Homework07;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int MODE_SINGLE = 0;
    public static final int MODE_MULTI = 1;
    public static final int FIELD_SIZE = 400;

    GameMap () {

        setBackground(Color.DARK_GRAY);
        setVisible(false);

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {

        int cellSize = (int) FIELD_SIZE/fieldSizeX;

        JPanel gameField = new JPanel();
        gameField.setBorder(BorderFactory.createLineBorder(Color.black ));
        gameField.setLayout(new GridLayout(fieldSizeY, fieldSizeX));
        gameField.setSize(fieldSizeX*cellSize,fieldSizeY*cellSize);

        JPanel[][] cellsArray = new JPanel[fieldSizeY][fieldSizeX];


        for (int i = 0; i < fieldSizeY; i++) {

            for (int j = 0; j < fieldSizeX; j++) {
                cellsArray[i][j] = new JPanel();
                cellsArray[i][j].setSize(cellSize,cellSize);
                cellsArray[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                gameField.add(cellsArray[i][j]);
            }

        }

        add(gameField, BorderLayout.CENTER);

        setVisible(true);
    }
}
