package leetcode.c1;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            int r = Arrays.binarySearch(sorted, i + 1, nums.length, target - sorted[i]);
            if (r > 0) {
                int p1 = sorted[i];
                int p2 = sorted[r];
                int r1 = 0, r2 = 0;
                int[] result = new int[2];
                int cnt=0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == p1 || nums[j] == p2) {
                        result[cnt++] = j;
                    }
                }
                Arrays.sort(result);
                return result;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] inp = {0,4,3,0};


        int[] ints = new Solution().twoSum(inp, 0);
        System.out.println("ints = " + ints.toString());
    }
}
