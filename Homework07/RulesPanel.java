package Homework07;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RulesPanel extends JPanel {

    private static final String RULES_FILE = "rules.txt";
    private static final int TEXTAREA_WIDTH = 25;
    private static final int TEXTAREA_HEIGHT = 15;

    RulesPanel(){

        JPanel rulesPanel = new JPanel();

        JTextArea textArea = new JTextArea(rulesReader(), TEXTAREA_HEIGHT, TEXTAREA_WIDTH);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);


        rulesPanel.add(scrollPane);
        add(rulesPanel);

    }

    private String rulesReader() {

        StringBuilder content = new StringBuilder();

        try {
            FileInputStream rulesFile = new FileInputStream(RULES_FILE);
            InputStreamReader converted = new InputStreamReader(rulesFile, "CP1251");

            int intChar;

            while ((intChar = converted.read()) != -1) {
                content.append((char) intChar);
            }

            rulesFile.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return content.toString();
    }
}
