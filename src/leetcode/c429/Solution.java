package leetcode.c429;
import leetcode._lib.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                subResult.add(poll.val);
                if (poll.children == null) {
                    continue;
                }
                for (Node child : poll.children) {
                    queue.add(child);
                }
            }
            result.add(subResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<Node>());
        root.children.add(new Node(2));
        root.children.add(new Node(3, new ArrayList<Node>()));
        root.children.get(1).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.add(new Node(4, new ArrayList<Node>()));
        root.children.get(2).children.add(new Node(8));
        root.children.add(new Node(5, new ArrayList<Node>()));
        root.children.get(3).children.add(new Node(9));

        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println("lists.toString() = " + lists.toString());
    }
}
