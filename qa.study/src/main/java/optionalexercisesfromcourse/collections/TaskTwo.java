// 2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
package optionalexercisesfromcourse.collections;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskTwo {
    static Scanner scanner;

    public static void main(String[] args) {
        showMenu();
        ArrayDeque<Character> stack = getStackWithDigits(scanner.nextLong());
        stack.forEach(System.out::print);
    }

    private static void showMenu() {
        scanner = new Scanner(System.in);
        System.out.print("Just input your number in here:\t");
        if (!scanner.hasNextLong()) {
            System.out.println("The number has not been inputted. Just try again!\n");
            showMenu();
        }
    }

    private static ArrayDeque<Character> getStackWithDigits(long givenNumber) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arrayOfDigits = String.valueOf(givenNumber).toCharArray();
        for (char digit : arrayOfDigits) {
            stack.push(digit);
        }
        return stack;
    }
}