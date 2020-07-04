package algorithms;

public class SearchInArrayMinMax {
    public static void main(String[] args) {
        int[] array = {2, -96, 55, 156, -85, 0, 9520, 11, 28, 101111};
        System.out.printf("Min value in the array:\t%d.\n", findMinValueInArray(array));
        System.out.printf("Max value in the array:\t%d.", findMaxValueInArray(array));
    }

    public static int findMinValueInArray(int[] array) {
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static int findMaxValueInArray(int[] array) {
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}

