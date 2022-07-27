package leetcode.c114;

import leetcode._lib.TreeNode;
import leetcode._lib.TreeNodeCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode resultTree = new TreeNode();
        //TreeNode lastNode = resultTree;
        TreeNode lastNode = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //lastNode.right = new TreeNode(node.val);
            //lastNode = lastNode.right;
            list.add(new TreeNode(node.val));
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        root.left = null;
        for (int i = 1; i < list.size(); i++) {
            lastNode.right = new TreeNode(list.get(i).val);
            lastNode = lastNode.right;
        }

        System.out.println("root = " + root);
    }

    public static void main(String[] args) {
        Integer[] inp = {1,2,5,3,4,null,6};
        TreeNode root = TreeNodeCreator.CreateTreeNode(inp);

        new Solution().flatten(root);

        System.out.println("root = " + root);

    }

}
