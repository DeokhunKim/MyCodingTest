package leetcode.c108;

import leetcode._lib.TreeNode;

import java.util.Arrays;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = null;
        if (nums.length > 2) {
            treeNode = new TreeNode(nums[nums.length / 2]);
            treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
            treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        } else if (nums.length == 2) {
            treeNode = new TreeNode(nums[1]);
            treeNode.left = new TreeNode(nums[0]);
        } else {
            treeNode = new TreeNode(nums[0]);
        }

        return treeNode;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = new Solution().sortedArrayToBST(nums);

        System.out.println("treeNode = " + treeNode);

    }


}
