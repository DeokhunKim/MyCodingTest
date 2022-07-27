package leetcode.c7;

public class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        int pn = 1;
        if (x < 0) {
            pn = -1;
        }
        while (x != 0) {
            int i = (x % 10) * pn;
            sb.append(i);
            x /= 10;
        }
        String s = sb.toString();
        if (s.equals("")) {
            return 0;
        }
        long l = Long.parseLong(s) * pn;
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        int i = Integer.parseInt(sb.toString())* pn;
        return i;
    }

    public static void main(String[] args) {
        int x = -2147483648;
        int reverse = new Solution().reverse(x);
        System.out.println("reverse = " + reverse);
    }
}
