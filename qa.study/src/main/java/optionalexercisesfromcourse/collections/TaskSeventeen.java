// Задан файл с текстом на английском языке. Выделить все различные слова.
// Для каждого слова подсчитать частоту его встречаемости.
// Слова, отличающиеся регистром букв, считать различными. Использовать класс HashMap
package optionalexercisesfromcourse.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TaskSeventeen {
    public static void main(String[] args) {
        File file = new File("src" + File.separator + "main" + File.separator
                             + "resources" + File.separator + "Starlight.txt");
        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (words.containsKey(word)) {
                    words.put(word, (words.get(word)+1));
                } else {
                    words.put(word, 1);
                }
            }
        } catch (FileNotFoundException exception) {
            System.err.println("File writing has been failed:\t" + exception);
        }
        words.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}