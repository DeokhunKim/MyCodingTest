package leetcode.c34;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    int min = 100001;
    int max = -1;
    public int[] searchRange(int[] nums, int target) {

        if(nums.length != 0)
            binarySearch(nums, 0, nums.length - 1, target);
        if(max == -1)
            min = -1;

        int[] result = {min, max};
        return result;
    }

    public void binarySearch(int[] nums, int s, int e, int target) {
        int middleIndex = (s + e) / 2;
        int middleVal = nums[middleIndex];
        if (s == e) {
            if (nums[s] == target) {
                storeVal(s);
            }
            return;
        }

        if (middleVal < target) {
            binarySearch(nums, middleIndex + 1, e, target);
        } else if (middleVal > target) {
            binarySearch(nums, s, middleIndex, target);
        } else {
            storeVal(middleIndex);
            binarySearch(nums, middleIndex + 1, e, target);
            binarySearch(nums, s, middleIndex, target);
        }

    }

    public void storeVal(int val) {
        if (val < min) {
            min = val;
        }
        if (val > max) {
            max = val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 6;

        int[] ints = new Solution().searchRange(nums, target);
        System.out.println("ints = " + ints);
    }
}
