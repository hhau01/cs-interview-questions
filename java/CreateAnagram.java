/*
    Create an anagram from two strings. In this context, the two strings should create the same string.

    E.g. "hello" and "billion"

    "hello" -> remove h,e -> "llo"
    "billion" -> remove b,i,i,n -> "llo"
    total removed: 6 characters

    We solve this problem by comparing the character counts of each string and removing the characters that do not match.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateAnagram {
    public static final int NUM_LETTERS = 26;

    public static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    public static int[] getCharCounts(String s) {
        int[] charCounts = new int[NUM_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }
    public static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first);
        int[] charCount2 = getCharCounts(second);
        return getDelta(charCount1, charCount2);
    }
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String first = br.readLine();
        // String second = br.readLine();
        // System.out.println(numberNeeded(first,second));
        assert (numberNeeded("hello","billion") == 6);
    }
}