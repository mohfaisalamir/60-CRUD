package com.enigma.purba_resto_jpa;

public class SimpleSort {
    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        selectionSort(arr);
        // Cetak array yang sudah diurutkan
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


        //f1. Fungsi untuk menemukan indeks elemen terkecil dalam array
        public static int findSmallest(int[] arr, int start) {
            int smallest = arr[start];
            int smallestIndex = start;
            for (int i = start + 1; i < arr.length; i++) {
                if (arr[i] < smallest) {
                    smallest = arr[i];
                    smallestIndex = i;
                }
            }
            return smallestIndex;
        }

        // f2. Fungsi untuk melakukan pengurutan selection sort
        public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int smallestIndex = findSmallest(arr, i);
                // Tukar elemen terkecil yang ditemukan dengan elemen di posisi i
                int temp = arr[i];
                arr[i] = arr[smallestIndex];
                arr[smallestIndex] = temp;
            }
        }
}
