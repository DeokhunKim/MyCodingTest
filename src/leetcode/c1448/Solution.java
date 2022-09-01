package leetcode.c1448;

import leetcode._lib.TreeNode;

public class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = -10001;
        travel(root, max);

        return count;
    }

    public void travel(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        int newMax = max;
        if (node.val >= max) {
            count++;
            newMax = node.val;
        }
        travel(node.left, newMax);
        travel(node.right, newMax);
    }

    public static void main(String[] args) {



    }
}
