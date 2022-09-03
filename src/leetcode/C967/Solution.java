package leetcode.C967;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {

        for (int i = 1; i < 10; i++) {
            if (0 <= i - k) {
                find(n, k, i, i - k);
            }
            if (i + k < 10 && k != 0) {
                find(n, k, i, i + k);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public void find(int n, int k, int num, int nextNum) {
        if (String.valueOf(num).length() == n - 1) {
            result.add(num * 10 + nextNum);
            return;
        }

        if (0 <= nextNum - k) {
            find(n, k, num * 10 + nextNum, nextNum - k);
        }
        if (nextNum + k < 10) {
            find(n, k, num * 10 + nextNum, nextNum + k);
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().numsSameConsecDiff(3, 7));
        //System.out.println(new Solution().numsSameConsecDiff(2, 1));
        System.out.println(new Solution().numsSameConsecDiff(2, 0));

    }


}
