package com.enigma.purba_resto_jpa;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        ArrayList<Integer> sortedArr = selectionSort(arr);
        System.out.println(sortedArr);
    }

        public static int findSmallest(ArrayList<Integer> arr) {
            int smallest = arr.get(0);
            int smallestIndex = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) < smallest) {
                    smallest = arr.get(i);
                    smallestIndex = i;
                }
            }
            return smallestIndex;
        }

        public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
            ArrayList<Integer> newArr = new ArrayList<>();
            int size = arr.size();
            for (int i = 0; i < size; i++) {
                int smallest = findSmallest(arr);
                newArr.add(arr.remove(smallest));
            }
            return newArr;
        }

}
