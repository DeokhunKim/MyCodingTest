package leetcode.c890;

import java.util.*;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String orderPattern = convertOrder(pattern);

        for (String word : words) {
            if (orderPattern.equals(convertOrder(word))) {
                result.add(word);
            }
        }

        return result;
    }

    private String convertOrder(String pattern) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        char orderABC = 'a';
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, orderABC);
                orderABC++;
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        List<String> andReplacePattern = new Solution().findAndReplacePattern(words, pattern);
        System.out.println("andReplacePattern.toString() = " + andReplacePattern.toString());
    }
}
