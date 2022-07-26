package leetcode.c5;

public class Solution {

    public String longestPalindrome(String s) {
        String result = "";
        int resultLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i < resultLen) {
                    continue;
                }
                boolean isFind = true;
                int wi = i;
                int wj = j;
                while (wi <= wj) {
                    if (s.charAt(wi) != s.charAt(wj)) {
                        isFind = false;
                        break;
                    }
                    wi++;
                    wj--;
                }
                if (isFind) {
                    String sub = s.substring(i, j+1);
                    if (resultLen < sub.length()) {
                        result = sub;
                        resultLen = result.length();
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        String s1 = new Solution().longestPalindrome(s);
        System.out.println("s1 = " + s1);
    }
}
