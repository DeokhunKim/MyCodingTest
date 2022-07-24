package leetcode.c240;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxh = matrix.length;
        int maxw = matrix[0].length;

        int i = 0;
        while (i < maxh && i < maxw) {
            final int f = i;
            int findW = Arrays.binarySearch(matrix[i], i, maxw, target);
            if (findW >= 0) {
                return true;
            }
            int[] targetArray = new int[maxw+1];
            targetArray[f] = target;
            int findH = Arrays.binarySearch(matrix, i, maxh, targetArray, Comparator.comparingInt((int[] t) -> (t[f])));
            if (findH >= 0) {
                return true;
            }

            maxh = (findH + 1 ) * -1;
            maxw = (findW + 1 ) * -1;
            i++;
        }


        return false;
    }

    public static void main(String[] args) {
        //int[][] inp = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] inp = {{20}};
        int target = 20;
        boolean b = new Solution().searchMatrix(inp, target);
        System.out.println("b = " + b);
    }
}
