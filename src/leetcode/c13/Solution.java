package leetcode.c13;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {
        Map<String, Integer> reverseMap = new HashMap<>();
        reverseMap.put("IV", 4);
        reverseMap.put("IX", 9);
        reverseMap.put("XL", 40);
        reverseMap.put("XC", 90);
        reverseMap.put("CD", 400);
        reverseMap.put("CM", 900);

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sb.append(s.charAt(i));
                break;
            }
            Integer integer = reverseMap.get(s.substring(i, i + 2));
            if (integer != null) {
                result += integer;
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }

        String str = sb.toString();
        for (int i = 0; i < sb.length(); i++) {
            result += map.get(str.charAt(i));
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        String s2 = "III";
        int i = new Solution().romanToInt(s);
        System.out.println("i = " + i);
    }
}
