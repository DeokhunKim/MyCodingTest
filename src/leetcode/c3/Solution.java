package leetcode.c3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> find = new HashMap<>();
        int maxLen = 0;
        int startIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (find.containsKey(s.charAt(i))) {
                if (find.size() > maxLen) {
                    maxLen = find.size();
                }
                Integer findIdx = find.get(s.charAt(i));
                for (int j = findIdx ; j >= startIdx; j--) {
                    find.remove(s.charAt(j));
                }
                startIdx = findIdx + 1;

            }
            find.put(s.charAt(i), i);
        }

        if (find.size() > maxLen) {
            maxLen = find.size();
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = " ";
        int i = new Solution().lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
}
