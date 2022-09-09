package leetcode.c1996;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static java.util.Comparator.comparingInt;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int result = 0;
        int[][] sorted = properties.clone();
        Arrays.sort(sorted, (a, b) -> (a[0] != b[0]) ? b[0] - a[0] : a[1] - b[1] );

        int max = 0;
        for (int[] ints : sorted) {
            if (ints[1] < max) {
                result++;
            }
            max = max < ints[1] ? ints[1] : max;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeakCharacters(new int[][]{{1, 1}, {2,2}, {3,3}, {2,3}}));
    }
}
