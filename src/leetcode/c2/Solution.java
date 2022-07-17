package leetcode.c2;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode() ;
        ListNode root = prevNode;
        int addNum = 0;
        while (true) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
            }
            if (l2 != null) {
                v2 = l2.val;
            }
            ListNode nextNode = new ListNode();
            prevNode.val = (v1 + v2 + addNum) % 10;


            addNum = (v1 + v2 + addNum) / 10;


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                if (addNum == 1) {
                    nextNode.val = 1;
                    prevNode.next = nextNode;
                }
                break;
            }
            prevNode.next = nextNode;
            prevNode = prevNode.next;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(3);
        ListNode t2 = new ListNode(4, t1);
        ListNode t3 = new ListNode(2, t2);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(6, t4);
        ListNode t6 = new ListNode(5, t5);

        ListNode listNode = new Solution().addTwoNumbers(t3, t6);

        System.out.println("listNode = " + listNode);

    }
}
