package leetcode.c1220;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countVowelPermutation(int n) {
        int[] num = new int['u' + 1];
        num['a'] = 1;
        num['e'] = 1;
        num['i'] = 1;
        num['o'] = 1;
        num['u'] = 1;

        if (n == 1) {
            return 5;
        }

        int result = 0;
        for (int c = 1; c < n; c++) {
            int a = num['e'];
            int e = num['a'] + num['i'];
            e %= 1000000007;
            int i = num['a'];
            i += num['e'];
            i %= 1000000007;
            i += num['o'];
            i %= 1000000007;
            i+= num['u'];
            i %= 1000000007;
            int o = num['i'] + num['u'];
            o %= 1000000007;
            int u = num['a'];

            num['a'] = a;
            num['e'] = e;
            num['i'] = i;
            num['o'] = o;
            num['u'] = u;
        }

        for (int value : num) {
            result += value;
            result %= 1000000007;
        }

        return result;
    }

    public static void main(String[] args) {
        int i = new Solution().countVowelPermutation(144);
        System.out.println("i = " + i);

    }
}
