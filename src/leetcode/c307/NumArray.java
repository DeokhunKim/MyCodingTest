package leetcode.c307;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class NumArray {
    int[] tree;
    int[] array;
    public NumArray(int[] nums) {
        int c = 1;
        int v = nums.length;
        while (true) {
            v /= 2;
            if (v == 0) {
                break;
            }
            c++;
        }
        final int p = (int)Math.pow(2, c + 1);
        tree = new int[p];
        tree[1] = createTree(nums, 1, 0, nums.length - 1);
        array = nums;
    }

    private int createTree(int[] nums, int index, int s, int e) {
        if (e - s == 0) {
            tree[index] = nums[s];
            return tree[index];
        } else if (e - s == 1) {
            tree[index * 2] = nums[s];
            tree[(index * 2) + 1] = nums[e];
            tree[index] = tree[index * 2] + tree[(index * 2) + 1];
            return tree[index];
        } else {
            tree[index] = createTree(nums, index * 2, s, s + ( (e-s) / 2) )
                    + createTree(nums, (index * 2) + 1, s + ( (e-s) / 2) + 1, e);
            return tree[index];
        }
    }

    public void update(int index, int val) {
        int changeVal = val - array[index];
        array[index] = val;

        int i = 1;
        int s = 1;
        int e = array.length;
        while (true) {
            tree[i] += changeVal;
            if (s == e) {
                break;
            }

            if (index < (s + e) / 2) {
                i *= 2;
                e = (s + e) / 2;
            } else {
                i = (i * 2) + 1;
                s = (s + e) / 2 + 1;
            }
        }

        return;
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, array.length -1 , 1);
    }

    private int sumRange(int left, int right, int s, int e, int index) {
        if (right < s) {
            return 0;
        } else if (e < left) {
            return 0;
        } else {
            if (left <= s && right >= e) {
                return tree[index];
            } else {
                int l = sumRange(left, right, s, (s + e) / 2, index * 2);
                int r = sumRange(left, right, (s + e) / 2 + 1, e, index * 2 + 1);
                return l + r;
            }

        }
    }
}
