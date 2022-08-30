package leetcode.c48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int deep = 0; deep < n / 2; deep++) {
            for (int step = deep; step < n - deep - 1; step++) {
                int[] rotateNum = {matrix[deep][step], matrix[step][n - deep - 1],
                        matrix[n - deep - 1][n - step - 1], matrix[n - step - 1][deep]};
                matrix[step][n - deep - 1] = rotateNum[0];
                matrix[n - deep - 1][n - step - 1] = rotateNum[1];
                matrix[n - step - 1][deep] = rotateNum[2];
                matrix[deep][step]= rotateNum[3];
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] input1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Solution().rotate(input1);
        System.out.println("input1 = " + input1);
    }
}
