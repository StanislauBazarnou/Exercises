package by.epam.com;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;


//Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке
public class NumberInStack {
    static Deque<Integer> stack;
    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Please type a number");
        inputNumber();
        printOutReverseNumber();
    }

    private static void inputNumber() {
        scanner = new Scanner(System.in);
        stack = new ArrayDeque<>();
        int m = 0;
        try {
            m = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please check your input");
            inputNumber();
        }
        scanner.close();
        while (m > 0) {
            stack.offer(m % 10);
            m = m / 10;
        }
    }

    private static void printOutReverseNumber() {
        while (!stack.isEmpty()) {
            System.out.print(stack.poll());
        }
    }
}
