package com.enigma.purba_resto_jpa;
//SOAL 2
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase().replaceAll("\\s", "");

        String vowels = "";
        String consonants = "";

        for (char ch : input.toCharArray()) {
            if (isVowel(ch)) {
                vowels += ch;
            } else {
                consonants += ch;
            }
        }

        System.out.println("Vowel Characters : ");
        System.out.println(sortCharacters(vowels));
        System.out.println("Consonant Characters : ");
        System.out.println(sortCharacters(consonants));
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static String sortCharacters(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }
}
