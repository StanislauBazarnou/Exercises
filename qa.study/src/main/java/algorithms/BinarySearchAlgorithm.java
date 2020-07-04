// Array must be sorted!
package algorithms;

public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        int[] smallArray = {2, 9, 53, 100, 102, 425, 500};
        int[] bigArray = {4, 8, 42, 55, 89, 99, 102, 136, 222, 896, 955, 1010, 1202};
        int key = 54;
        int keyPosition = binarySearch(key, bigArray);
        System.out.printf("Key: %d, its position in the array: %d", key, keyPosition);
    }

    public static int binarySearch(int key, int[] array) {
        int leftElement = 0;
        int rightElement = array.length-1;

        while (leftElement <= rightElement) {
            int middleElement = (leftElement + rightElement)/2;
            if (array[middleElement] == key) {
                System.out.println("\nThe Key has been found!");
                return middleElement;
            }

            if (array[middleElement] < key) {
                System.out.println("Cut left part of array");
                leftElement = middleElement + 1;
            }

            if (array[middleElement] > key) {
                System.out.println("Cut right part of array");
                rightElement = middleElement - 1;
            }
        }
        return -1;
    }
}
