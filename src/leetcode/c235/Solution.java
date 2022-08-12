package leetcode.c235;

import leetcode._lib.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val < q.val ? p.val : q.val;
        int big = p.val >= q.val ? p.val : q.val;
        while (true) {
            if (small <= root.val && root.val <= big) {
                return root;
            } else if (q.val <= root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().lowestCommonAncestor(null, new TreeNode(2), new TreeNode(1));
    }
}