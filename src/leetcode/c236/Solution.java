package leetcode.c236;

import leetcode._lib.TreeNode;
import leetcode._lib.TreeNodeCreator;

import java.util.*;

public class Solution {

    List<Integer> firstFind = new ArrayList<>();
    List<Integer> secondFind = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 스택을 이용해서 깊이우선 탐색을 하고
        // 먼저 하나 찾으면 해당 스택을 복제하고
        // 다른 하나 찾으면 앞서 찾았던 스택이랑 밑에서 부터 비교해와서 틀려지기 직전의 노드가 정답


        stack.add(root);
        recu(p, q);


        int result = 0;
        for (int i = 0; ; i++) {
            if (i >= firstFind.size() || i >= secondFind.size()) {
                break;
            }
            if (!firstFind.get(i).equals(secondFind.get(i))) {
                break;
            }
            result = firstFind.get(i);
        }


        return new TreeNode(result);
    }

    public boolean recu(TreeNode p, TreeNode q) {
        TreeNode node = stack.peek();
        if (node.val == p.val || node.val == q.val) {
            if (firstFind.isEmpty()) {
                for (TreeNode stackNode : stack) {
                    firstFind.add( stackNode.val);
                }
            } else {
                for (TreeNode stackNode : stack) {
                    secondFind.add( stackNode.val);
                }
                return false;
            }
        }

        if (node.left != null) {
            stack.add(node.left);
            if (!recu(p, q)) {
                return false;
            }
        }
        if (node.right != null) {
            stack.add(node.right);
            if (!recu(p, q)) {
                return false;
            }
        }

        stack.pop();

        return true;
    }

    public static void main(String[] args) {
        //3,5,1,6,2,0,8,null,null,7,4

        Integer[] inp = {-1, 0, null, 1, null, null, null, 3, null, null, null, null, null, null, null, 7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 10 };
        //Integer[] inp = {1, 2};

        TreeNode root = TreeNodeCreator.CreateTreeNode(inp);

        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(10);

        TreeNode treeNode = new Solution().lowestCommonAncestor(root, p, q);

        System.out.println("treeNode = " + treeNode.val);

    }

}
