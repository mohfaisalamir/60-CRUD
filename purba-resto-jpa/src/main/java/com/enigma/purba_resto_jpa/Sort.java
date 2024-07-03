package com.enigma.purba_resto_jpa;

public class Sort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 5, 6, 5, 3, 42, 1};
        int temp;

        // Bubble Sort algorithm
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
