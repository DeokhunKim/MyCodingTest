package leetcode.c300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[2501];
        int idx = 1;
        arr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int searchIdx = Arrays.binarySearch(arr, 0, idx, nums[i]);
            if (searchIdx < 0) {
                searchIdx = (searchIdx + 1) * -1;
                if (searchIdx == idx) {
                    arr[idx++] = nums[i];
                } else {
                    arr[searchIdx] = arr[searchIdx] < nums[i] ? arr[searchIdx] : nums[i];
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] inp1 = {10, 9, 2, 5, 3, 7, 101, 18}; // 4
        int[] inp2 = {1, 10, 11, 12, 13, 3, 4, 5, 6, 7, 8, 9}; // 8
        int[] inp3 = {0,1,0,3,2,3};


        int i = new Solution().lengthOfLIS(inp3);
        System.out.println("i = " + i);
    }
}
