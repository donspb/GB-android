package Homework07;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {

    private static final String VER = "0.1a";

    AboutPanel() {

        JPanel aboutPanel = new JPanel();
        JLabel aboutLabel = new JLabel("Программа Tic-Tac-Toe");
        JLabel aboutLabel2 = new JLabel("Игра в крестики-нолики");
        JLabel aboutLabel3 = new JLabel("Версия: " + VER);
        JLabel aboutLabel4 = new JLabel("By donspb 2020");

        aboutPanel.setLayout(new GridLayout(4,1));
        aboutPanel.add(aboutLabel);
        aboutPanel.add(aboutLabel2);
        aboutPanel.add(aboutLabel3);
        aboutPanel.add(aboutLabel4);

        add(aboutPanel);
    }


}
