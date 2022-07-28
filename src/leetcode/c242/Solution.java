package leetcode.c242;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        int[] sf = new int[26];
        int[] tf = new int[26];
        Arrays.fill(sf, 0);
        Arrays.fill(tf, 0);

        for (int i = 0; i < s.length(); ++i) {
            sf[s.charAt(i) - 97]++;
        }
        for (int i = 0; i <t.length(); ++i) {
            tf[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; ++i) {
            if (sf[i] != tf[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        boolean anagram = new Solution().isAnagram(s, t);
        System.out.println("anagram = " + anagram);
    }
}
