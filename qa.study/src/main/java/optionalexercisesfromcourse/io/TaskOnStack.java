package by.epam.com;

import java.util.ArrayDeque;
import java.util.Deque;

//  Задать два стека, поменять информацию местами
public class TaskOnStack {
    static Deque<Integer> firstStack = new ArrayDeque<>();
    static Deque<Integer> secondStack = new ArrayDeque<>();
    static Deque<Integer> temporalStack = new ArrayDeque<>();

    public static void main(String[] args) {
        fillStacksWithNumbers();

        temporalStack.addAll(firstStack);
        firstStack.clear();
        firstStack.addAll(secondStack);
        secondStack.clear();
        secondStack.addAll(temporalStack);
        temporalStack.clear();

        printOutStack(firstStack);
    }

    private static void fillStacksWithNumbers() {
        for (int i = 0; i < 5; i++) {
            firstStack.push(i); //fill stack with numbers from 0 to 4
            secondStack.push(i + 5); // fill stack with number from 5 to 9
        }
    }

    private static void printOutStack(Deque<Integer> firstStack) {
        for (int i = 0; i < 5; i++) {
            System.out.println(firstStack.pop());
        }
    }
}
