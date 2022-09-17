package leetcode.c336;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {
            hash.put(words[wordIdx], wordIdx);
        }

        for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {
            String word = words[wordIdx];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(word.charAt(word.length() - i - 1));
                String reverseWord = sb.toString();
                if (hash.containsKey(reverseWord) && hash.get(reverseWord) != wordIdx && check(reverseWord, word)) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(hash.get(reverseWord), wordIdx));
                    result.add(list);
                }
            }
            if (word.equals("")) {
                Integer hashIdx = hash.get("");
                for (int i = 0; i < words.length; i++) {
                    if (hashIdx != i && check(words[i], "")) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(hashIdx, i));
                        result.add(list);
                        list = new ArrayList<>(Arrays.asList(i, hashIdx));
                        result.add(list);
                    }
                }

            }
        }

        return result;
    }

    private boolean check(String word1, String word2) {
        String word = word1 + word2;
        for (int i = 0; i <= word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{"a","b","c","ab","ac","aa"}));
        System.out.println(new Solution().palindromePairs(new String[]{"a","abc","aba",""}));
        System.out.println(new Solution().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(new Solution().palindromePairs(new String[]{"bat","tab","cat"}));
        System.out.println(new Solution().palindromePairs(new String[]{"a", ""}));
    }
}
