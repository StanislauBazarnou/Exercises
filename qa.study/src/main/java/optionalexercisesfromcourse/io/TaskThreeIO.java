// Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

package optionalexercisesfromcourse.io;

import java.io.*;
import java.util.Scanner;

public class TaskThreeIO {
    public static void main(String[] args) {
        File sourceFile = new File("src" + File.separator + "main" + File.separator + "java"
                                   + File.separator + "optionalexercisesfromcourse" + File.separator
                                   + "io" + File.separator + "TaskThreeIO.java");
        File destinationFile = new File("src" + File.separator + "main" + File.separator
                                        + "resources" + File.separator + "DestinationFile.txt");

        String reversedContent = getReversedContent(sourceFile);
        writeContentToFile(reversedContent, destinationFile);
    }

    private static String getReversedContent(File sourceFile) {
        StringBuilder reversedContent = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(sourceFile))) {
            while (scanner.hasNext()) {
                StringBuilder scannedString = new StringBuilder();
                scannedString.append(scanner.nextLine()).reverse();
                reversedContent.append(scannedString).append("\n");
            }
        } catch (FileNotFoundException exception) {
            System.err.println("File " + sourceFile.getName() + " has not been found.");
        }
        return reversedContent.toString();
    }

    private static void writeContentToFile(String reversedContent, File destinationFile) {
        if (!reversedContent.isEmpty()) {
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                                                               new FileWriter(destinationFile)))) {
                printWriter.print(reversedContent);
                System.out.println("File \"" + destinationFile.getName()
                                   + "\" has been successfully written.");
            } catch(IOException exception){
                System.err.println("File writing has been failed:\n" + exception);
            }
        } else {
            System.out.println("File \"" + destinationFile.getName() + "\" has not been written "
                               + "in the absence of source file.");
        }
    }
}