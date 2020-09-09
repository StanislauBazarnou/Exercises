package by.epam.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Задан файл с текстом на английском языке. Выделить все различные слова. Для каждого слова подсчитать
// частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
// Использовать класс HashMap
public class CountDifferentWordsInText {
    static File file = new File("src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "englishText.txt");
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        readTheFile();
        printOutMap(sortByValue());
    }

    private static void readTheFile() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().replaceAll("\\p{Punct}", "").split(" ");
                for (String word : str) {
                    int count = map.containsKey(word) ? map.get(word) : 0;
                    map.put(word, count + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, Integer> sortByValue() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((o2, o1) -> (o1.getValue()).compareTo(o2.getValue()));

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> word : list) {
            temp.put(word.getKey(), word.getValue());
        }
        return temp;
    }

    private static void printOutMap(HashMap<String, Integer> temp) {
        for (Map.Entry<String, Integer> e : temp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
