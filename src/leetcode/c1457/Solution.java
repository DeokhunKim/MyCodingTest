package leetcode.c1457;

import leetcode._lib.TreeNode;
import leetcode._lib.TreeNodeCreator;

public class Solution {
    int result = 0;
    int nodeCount = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        // palindromic 조건
        // 길이가 짝수일 경우 -> 개당 수가 짝수
        // 길이가 홀수일 경우 -> 홀수가 1개, 나머지는 짝수
        boolean[] digit = {false, false, false, false, false, false, false, false, false, false};
        find(root, digit);

        return result;
    }

    private int find(TreeNode node, boolean[] digit) {
        digit[node.val] = !digit[node.val];
        nodeCount++;
        if (node.left == null && node.right == null) {
            if (isPalindromic(digit)) {
                result++;
            }
        }
        if (node.left != null) {
            int i = find(node.left, digit);
            digit[i] = !digit[i];
            nodeCount--;
        }
        if (node.right != null) {
            int i = find(node.right, digit);
            digit[i] = !digit[i];
            nodeCount--;
        }

        return node.val;
    }

    private boolean isPalindromic(boolean[] digit) {
        int trueCount = 0;
        for (int i = 1; i <= 9; i++) {
            if (digit[i] == true) {
                trueCount++;
            }
        }
        if (nodeCount % 2 == 0 && trueCount == 0) {
            return true;
        } else if (nodeCount % 2 == 1 && trueCount == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //TreeNode treeNode = TreeNodeCreator.CreateTreeNode(new Integer[]{2, 3, 1, 3, 1, null, 1});
        //System.out.println(new Solution().pseudoPalindromicPaths(treeNode));

        TreeNode treeNode = TreeNodeCreator.CreateTreeNode2(new Integer[]{1,9,1,null,1,null,1,null,null,7,null,null,4});
        System.out.println(new Solution().pseudoPalindromicPaths(treeNode));
    }
}
