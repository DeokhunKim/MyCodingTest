package leetcode.c98;

import leetcode._lib.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer num = null;
    public boolean isValidBST(TreeNode root) {

        if (root.left != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
        }
        if (num == null) {
            num = root.val;
        }
        else if (num >= root.val) {
            return false;
        } else {
            num = root.val;
        }

        if (root.right != null) {
            if (!isValidBST(root.right)) {
                return false;
            }
        }

        return true;

    }


}