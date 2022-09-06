package leetcode.c814;

import leetcode._lib.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode result = root;

        result = removeZero(result) ? null : result;

        return result;
    }

    public boolean removeZero(TreeNode node) {
        if (node.left != null) {
            if (removeZero(node.left)) {
                node.left = null;
            }
        }
        if (node.right != null) {
            if (removeZero(node.right)) {
                node.right = null;
            }
        }

        if (node.left == null && node.right == null) {
            if (node.val == 0) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
