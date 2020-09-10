package by.epam.com;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// 3. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки
public class Task3 {
    static File fileToRead = new File("src/main/resources/file.txt");
    static File writeToFile = new File("src/main/resources/Task3.txt");
    static Scanner scanner;
    static Writer writer;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        readFromFile();
        reverseSymbolsInArray();
        writeSymbolsToFile();
    }

    private static void readFromFile() {
        try {
            scanner = new Scanner(fileToRead);
            while(scanner.hasNextLine()) {
                list.add(new StringBuilder(scanner.nextLine()).reverse().toString());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> reverseSymbolsInArray() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        return list;
    }

    private static void writeSymbolsToFile() {
        if(!writeToFile.exists()) {
            try {
                writeToFile.createNewFile();
                writer = new FileWriter(writeToFile);
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i) + "\n");
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
