package leetcode.c378;

import java.util.Arrays;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] sortedArray = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            int[] newArray = new int[k];
            int sidx = 0, midx = 0;
            int max = 0;
            for (int j = 0; j < k; j++) {
                if (sidx == sortedArray.length && midx == matrix[i].length) {
                    max = sidx + midx;
                    break;
                } else if (sidx == sortedArray.length) {
                    newArray[j] = matrix[i][midx++];
                } else if (midx == matrix[i].length) {
                    newArray[j] = sortedArray[sidx++];
                } else {
                    newArray[j] = sortedArray[sidx] < matrix[i][midx] ? sortedArray[sidx++] : matrix[i][midx++];
                }
            }
            if(0 < max)
                sortedArray = Arrays.copyOfRange(newArray, 0, max);
            else
                sortedArray = newArray;

        }

        return sortedArray[k-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        //int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 1;
        int i = new Solution().kthSmallest(matrix, k);
        System.out.println("i = " + i);
    }


}
