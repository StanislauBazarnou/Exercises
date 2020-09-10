package by.epam.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке
public class ReverseLines {
    static File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator +
            "file.txt");
    static List<String> list;

    public static void main(String[] args) {
        readFile();
        writeArrayToFile();
    }

    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = new ArrayList<>();
            while (reader.ready()) {
                list.add(new StringBuilder(reader.readLine()).reverse().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeArrayToFile() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            writer.write("\n");
            for (String line : list) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
