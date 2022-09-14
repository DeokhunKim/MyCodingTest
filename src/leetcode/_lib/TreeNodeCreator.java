package leetcode._lib;

import java.util.LinkedList;

public abstract class TreeNodeCreator {
    public static TreeNode CreateTreeNode(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            TreeNode pNode = root;

            int level = 0;
            for (int j = 2; ; j++) {
                if (i <= ((int) Math.pow(2, j)) - 2) {
                    level = j;
                    break;
                }
            }

            int max = ((int) Math.pow(2, level)) - 2;
            int min = ((int) Math.pow(2, level - 1)) - 1;
            for (int j = level; j > 1; j--) {
                double middleVal = (max + min) / 2.0;
                if (j != 2) {
                    if ((double) i < middleVal ){
                        pNode = pNode.left;
                        max = (int)Math.floor(middleVal);
                    } else {
                        pNode = pNode.right;
                        min = (int)Math.ceil(middleVal);
                    }
                } else {
                    TreeNode node = new TreeNode(arr[i]);
                    if ((double) i < middleVal) {
                        pNode.left = node;
                    } else {
                        pNode.right = node;
                    }
                }

            }

        }

        return root;
    }

    public static TreeNode CreateTreeNode2(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (arr.length > index && arr[index] != null) {
                    node.left = new TreeNode(arr[index]);
                    queue.addLast(node.left);
                }
                index++;
                if (arr.length > index && arr[index] != null ) {
                    node.right = new TreeNode(arr[index]);
                    queue.addLast(node.right);
                }
                index++;
            }
        }

        return root;
    }
}
