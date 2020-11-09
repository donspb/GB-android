package Homework06;

import java.io.*;
import java.util.Scanner;

public class Homework06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String wordToSearch;
        String pathToSearch;

        fileMerger("result.txt",fileReader("first.txt"),fileReader("second.txt"));

        System.out.println("Слово для поиска:");
        wordToSearch = scanner.nextLine();

        System.out.println("Наличие слова в файле result.txt: " + wordSeeker(wordToSearch,"result.txt"));
        System.out.println();
        System.out.println("Папка для поиска:");
        pathToSearch = scanner.nextLine();
        System.out.println("Слово для поиска в папке:");
        wordToSearch = scanner.nextLine();

        System.out.println(inFolderSeeker(wordToSearch,pathToSearch));

    }

    public static String inFolderSeeker(String word, String path) {

        File folder = new File(path);
        String[] filesList = folder.list();

        for (int i = 0; i < filesList.length; i++)
            if (wordSeeker(word, path + filesList[i])) return "Искомое слово есть в файле " + filesList[i];

        return "Слово не найдено!";
    }

    public static boolean wordSeeker(String word, String path) {

        StringBuilder oneWord = new StringBuilder();

        try {
            FileInputStream inFile = new FileInputStream(path);
            InputStreamReader converted = new InputStreamReader(inFile, "UTF8");

            int intChar;

            while ((intChar = converted.read()) != -1) {
                if ((char) intChar == ' ' || (char) intChar == ',' || (char) intChar == '.') {
                    if (word.equals(oneWord.toString())) return true;
                    else oneWord.delete(0,oneWord.length());
                }
                else oneWord.append((char) intChar);
            }

            inFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    static String fileReader(String path) {

        StringBuilder content = new StringBuilder("");

        try {
            FileInputStream fromFile = new FileInputStream(path);
            InputStreamReader converted = new InputStreamReader(fromFile, "UTF8");

            int intChar;

            while ((intChar = converted.read()) != -1) {
                content.append((char) intChar);
            }

            fromFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return content.toString();

    }

    static void fileMerger(String path, String contentOne, String contentTwo) {

        try {

            PrintStream toFile = new PrintStream(new FileOutputStream(path));
            toFile.println(contentOne + "\n" + contentTwo);
            toFile.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}