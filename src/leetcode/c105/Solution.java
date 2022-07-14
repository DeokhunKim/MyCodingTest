package leetcode.c105;

import java.util.Arrays;

public class Solution {
    int index = 0;
    int[] m_preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        m_preorder = preorder;

        int newVal = m_preorder[0];
        int i = searchIndexOf(inorder, newVal);
        int[] ln = Arrays.copyOfRange(inorder, 0, i);
        int[] rn = Arrays.copyOfRange(inorder, i+1, inorder.length);
        TreeNode treeNode = splitTree(ln, rn, newVal);

        return treeNode;
    }

    public TreeNode splitTree(int[] left, int[] right, int val) {
        //Preorder sequence: A B D E C F
        //Inorder sequence: D B E A F C

        TreeNode pn = new TreeNode(val);
        if (left.length != 0) {
            int newVal = m_preorder[++index];
            int i = searchIndexOf(left, newVal);
            int[] ln = Arrays.copyOfRange(left, 0, i);
            int[] rn = Arrays.copyOfRange(left, i+1, left.length);
            pn.left = splitTree(ln, rn, newVal);
        }
        if (right.length != 0) {
            int newVal = m_preorder[++index];
            int i = searchIndexOf(right, newVal);
            int[] ln = Arrays.copyOfRange(right, 0, i);
            int[] rn = Arrays.copyOfRange(right, i+1, right.length);
            pn.right = splitTree(ln, rn, newVal);
        }

        return pn;
    }

    int searchIndexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder ={3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new Solution().buildTree(preorder, inorder);

        System.out.println("treeNode = " + treeNode);

    }

}
