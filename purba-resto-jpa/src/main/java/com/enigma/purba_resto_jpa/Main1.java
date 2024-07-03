package com.enigma.purba_resto_jpa;
// SOAL 1 PSBB

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Membaca jumlah keluarga
        int n = Integer.parseInt(scan.nextLine().trim());

        // Membaca jumlah anggota setiap keluarga
        String input = scan.nextLine();
        String[] familySizesInput = input.split(" ");

        // Validasi jumlah keluarga dengan jumlah input yang diberikan
        if (familySizesInput.length != n) {
            System.out.println("Input must be equal with count of family");
            return;
        }

        // Mengonversi input menjadi daftar integer
        List<Integer> familySizes = new ArrayList<>();
        for (String size : familySizesInput) {
            familySizes.add(Integer.parseInt(size));
        }

        // Menghitung jumlah minimal bus yang dibutuhkan
        int busCount = calculateMinimumBuses(familySizes);
        System.out.println("Minimum bus required is : " + busCount);
    }

    public static int calculateMinimumBuses(List<Integer> familySizes) {
        // Urutkan daftar keluarga dalam urutan menurun
        Collections.sort(familySizes, Collections.reverseOrder());

        int i = 0, j = familySizes.size() - 1;
        int busCount = 0;

        while (i <= j) {
            // Tambahkan bus baru
            busCount++;
            // Cek jika dua keluarga bisa masuk dalam satu bus
            if (i != j && familySizes.get(i) + familySizes.get(j) <= 4) {
                j--;  // Gunakan keluarga paling kecil juga
            }
            i++;  // Gunakan keluarga paling besar
        }

        return busCount;
    }
}
