package by.epam.com;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию

public class RandomNumbersInAFile {
    static File file = new File("src/main/resources/file.txt");
    static ArrayList<Integer> listToSort;
    static FileWriter writer;
    static Scanner scanner;

    public static void main(String[] args) {
        if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            writeRandomNumbersToFile();
            readNumbersFromFile();
            sortNumbersInArray();
            writeSortedNumbersToFile();
    }

    public static int createRandomNumbers(int range) {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(range);
        return randomNumber;
    }

    public static void writeRandomNumbersToFile() {
        try {
            writer = new FileWriter(file);
            for (int i = 0; i < 20; i++) {
                writer.write(createRandomNumbers(100) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readNumbersFromFile() {
        listToSort = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                listToSort.add(scanner.nextInt());
            }
            scanner.close();
        } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static ArrayList<Integer> sortNumbersInArray() {
        Collections.sort(listToSort);
        return listToSort;
    }

    private static void writeSortedNumbersToFile() {
        try {
        writer = new FileWriter(file, true);
        writer.write("\n");
        writer.flush();
        for (int i = 0; i < listToSort.size(); i++) {
            writer.write(listToSort.get(i) + " ");
        }
            writer.close();
        } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
