package leetcode.c637;

import leetcode._lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nextQueue = new ArrayList<>();
            double sum = 0.0;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                sum += node.val;
                if (node.left != null) {
                    nextQueue.add(node.left);
                }
                if (node.right != null) {
                    nextQueue.add(node.right);
                }
            }
            result.add(sum/queue.size());
            queue = nextQueue;
        }

        return result;
    }

    public static void main(String[] args) {


    }
}