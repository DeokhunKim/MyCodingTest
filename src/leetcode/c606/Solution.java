package leetcode.c606;

import leetcode._lib.TreeNode;

class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        StringBuilder result = new StringBuilder(String.valueOf(root.val));
        result.append("(" + tree2str(root.left) + ")");
        if(root.right != null)
            result.append("(" + tree2str(root.right) + ")");

        return result.toString();
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(new Solution().tree2str(t1));
    }

}