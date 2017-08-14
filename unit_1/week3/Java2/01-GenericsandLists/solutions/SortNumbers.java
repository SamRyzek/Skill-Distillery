package solutions;

import java.util.ArrayList;
import java.util.List;

public class SortNumbers {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(Math.random());
        }

        System.out.println("Before Sort:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%.3f%n", numbers.get(i));
        }

        bubbleSort(numbers);
        insertionSort(numbers);
        System.out.println("After sort");
        for (double num : numbers) {
            System.out.printf("%.3f%n", num);
        }
    }

    private static void bubbleSort(List<Double> nums) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) > nums.get(i + 1)) {
                    // swap elements
                    double temp = nums.get(i);
                    nums.set(i, nums.get(i + 1));
                    nums.set(i + 1, temp);
                    swapped = true;
                }
            }
        }
    }

    private static void insertionSort(List<Double> nums) {
        for (int i = 1; i < nums.size(); i++) {
            double temp = nums.get(i);
            int j = i;

            while (j > 0 && nums.get(j - 1) > temp) {
                nums.set(j, nums.get(j - 1));
                j--;
            }
            nums.set(j, temp);
        }

    }
}
