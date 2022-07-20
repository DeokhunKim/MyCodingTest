package leetcode.c792;

import java.util.*;

public class Solution2 {
    Set<String> collect = new HashSet<>();
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, LinkedList<Integer>> m = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            m.put(i, new LinkedList<>());
        }
        for (int i = 0; i < words.length; i++) {
            m.get(words[i].charAt(0)).add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            LinkedList<Integer> integers = m.get(c);
            int size = integers.size();
            for (int j = 0; j < size; j++) {
                Integer index = integers.poll();
                words[index] = words[index].substring(1, words[index].length());
                if (words[index].equals("")) {
                    result++;
                } else {
                    m.get(words[index].charAt(0)).add(index);
                }
            }

        }

        return result;
    }



    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};

        int i = new Solution2().numMatchingSubseq(s, words);
        System.out.println("i = " + i);


    }
}
