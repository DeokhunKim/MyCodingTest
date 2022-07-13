package leetcode.c102;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        //result.add(new ArrayList<>(root.val));
        List<TreeNode> prevNode = new ArrayList<>();
        prevNode.add(root);

        while(true){
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nextNode = new ArrayList<>();
            for (TreeNode node : prevNode) {
                if (node.left != null) {
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    nextNode.add(node.right);
                }
                level.add(node.val);
            }
            if (level.isEmpty()) {
                break;
            }
            result.add(level);
            prevNode = nextNode;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode();
        TreeNode treeNode4 = new TreeNode();
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(17);

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

        List<List<Integer>> lists = new Solution().levelOrder(treeNode0);

        System.out.println("lists = " + lists);
    }

}