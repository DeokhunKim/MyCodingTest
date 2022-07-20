package leetcode.c792;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> collect = new HashSet<>();
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;

        recu("", s);

        for (String word : words) {
            if (collect.contains(word)) {
                result++;
            }
        }

        return result;
    }

    public void recu(String s, String e) {
        if (e.length() == 0) {
            collect.add(s);
            return;
        }
        String sub = e.substring(1, e.length());
        recu(s + e.charAt(0), sub);
        recu(s, sub);

    }

    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};

        int i = new Solution().numMatchingSubseq(s, words);
        System.out.println("i = " + i);


    }
}
