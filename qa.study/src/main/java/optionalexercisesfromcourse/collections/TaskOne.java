// 1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
package optionalexercisesfromcourse.collections;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) throws FileNotFoundException {
        File fileToRead = new File("src" + File.separator + "main" + File.separator
                                   + "resources" + File.separator + "Starlight.txt");
        File fileToWrite = new File("src" + File.separator + "main"
                                    + File.separator + "resources" + File.separator
                                    + "Starlight (reversed).txt");
        ArrayList<String> list = getListWithFileContent(fileToRead);
        Collections.reverse(list);
        writeListContentToFile(list, fileToWrite);
    }

    private static ArrayList<String> getListWithFileContent(File fileToRead) {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(fileToRead))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.err.println("File writing has been failed:\t" + exception);
        }
        return list;
    }

    private static void writeListContentToFile(ArrayList<String> list, File fileToWrite) {
        if (!list.isEmpty()) {
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                                                               new FileWriter(fileToWrite)))) {
                list.forEach(printWriter::println);
                System.out.println("File \"" + fileToWrite.getName()
                                   + "\" has been successfully written.");
            } catch(IOException exception){
                System.err.println("File writing has been failed:\n" + exception);
            }
        } else {
            System.out.println("File \"" + fileToWrite.getName() + "\" has not been written "
                               + "in the absence of file for reading.");
        }
    }
}