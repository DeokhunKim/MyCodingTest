package leetcode.c94;

import leetcode._lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null)
            travel(root, result);
        return result;
    }

    private void travel(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            travel(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            travel(node.right, result);
        }
    }
}
