// Задать два стека, поменять информацию местами
package optionalexercisesfromcourse.collections;

import java.util.ArrayDeque;
import java.util.Random;

public class TaskSeven {
    public static void main(String[] args) {
        ArrayDeque<Integer> stackOne = createStackWithRandomNumbers(6);
        ArrayDeque<Integer> stackTwo = createStackWithRandomNumbers(8);

        printStacks(stackOne, stackTwo);
        swapData(stackOne, stackTwo);
        printStacks(stackOne, stackTwo);
    }

    private static ArrayDeque<Integer> createStackWithRandomNumbers(int size) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(size);
        new Random().ints(size, -1000, 1000)
                    .forEach(stack::push);
        return stack;
    }

    private static void printStacks(ArrayDeque<Integer> stackOne, ArrayDeque<Integer> stackTwo) {
        System.out.println("\nStack 1:");
        stackOne.forEach(System.out::println);
        System.out.println("\nStack 2:");
        stackTwo.forEach(System.out::println);
    }

    private static void swapData(ArrayDeque<Integer> stackOne, ArrayDeque<Integer> stackTwo) {
        ArrayDeque<Integer> tempStack = new ArrayDeque<>(stackOne);
        stackOne.clear();
        stackOne.addAll(stackTwo);
        stackTwo.clear();
        stackTwo.addAll(tempStack);
    }
}