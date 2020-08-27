// Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

package optionalexercisesfromcourse.io;

import java.io.*;
import java.util.Scanner;

public class TaskThreeIO {
    public static void main(String[] args) {
        File sourceFile = new File("src" + File.separator + "main" + File.separator + "java"
                                   + File.separator + "optionalexercisesfromcourse" + File.separator
                                   + "io" + File.separator + "TaskThreeIO.java");
        File destinationFile = new File("src" + File.separator + "main" + File.separator + "java"
                                        + File.separator + "optionalexercisesfromcourse" + File.separator
                                        + "io" + File.separator + "DestinationFile.txt");

        writeContentToFile(sourceFile, destinationFile);
    }

    public static void writeContentToFile(File sourceFile, File destinationFile) {
        if (sourceFile.exists()) {
            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                                                               new FileWriter(destinationFile)))) {
                printWriter.print(getReversedContent(sourceFile));
                System.out.println("File \"" + destinationFile.getName()
                                   + "\" has been successfully written.");
            } catch(IOException exception){
                System.err.println("File writing has been failed:\n" + exception);
            }
        } else {
            System.out.println("In the absence of file \"" + sourceFile.getName() + "\"  "
                               + "file \"" + destinationFile.getName() + "\" has not been written.");
        }
    }

    private static String getReversedContent(File sourceFile) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(sourceFile))) {
            while (scanner.hasNext()) {
                StringBuilder scannedString = new StringBuilder();
                scannedString.append("\n").append(scanner.nextLine()).reverse();
                content.append(scannedString);
            }
        } catch (FileNotFoundException exception) {
            System.err.println("File " + sourceFile.getName() + " has not been found.");
        }
        return content.toString();
    }
}