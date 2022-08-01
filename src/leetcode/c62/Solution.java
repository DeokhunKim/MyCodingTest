package leetcode.c62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int uniquePaths(int m, int n) {
        int [][] visit = new int[m][n];
        for (int[] booleans : visit) {
            Arrays.fill(booleans, 0);
        }
        int result = 0;
        List<Integer> wait_m = new ArrayList<>();
        List<Integer> wait_n = new ArrayList<>();
        wait_m.add(0);
        wait_n.add(0);
        visit[0][0] = 1;

        while (result == 0) {
            List<Integer> new_m = new ArrayList<>();
            List<Integer> new_n = new ArrayList<>();
            for (int i = 0; i < wait_m.size(); i++) {
                int target_m = wait_m.get(i);
                int target_n = wait_n.get(i);

                if (( target_m == m - 1 && target_n == n - 1) ||
                        ( target_m == m - 1 && target_n == n - 1) ) {
                    return visit[target_m][target_n];
                }

                if (target_m < m - 1) {
                    if (visit[target_m + 1][target_n] == 0) {
                        new_m.add(target_m + 1);
                        new_n.add(target_n);
                    }

                    visit[target_m + 1][target_n] += visit[target_m][target_n];
                }
                if (target_n < n - 1 ) {
                    if (visit[target_m][target_n + 1] == 0) {
                        new_m.add(target_m);
                        new_n.add(target_n + 1);
                    }

                    visit[target_m][target_n + 1] += visit[target_m][target_n];
                }

            }
            wait_m.clear();
            wait_n.clear();
            wait_m = new_m;
            wait_n = new_n;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(3, 7);
        System.out.println("i = " + i);
    }

}
