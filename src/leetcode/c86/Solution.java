package leetcode.c86;

import leetcode._lib.ListNode;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-300);
        ListNode rightHead = new ListNode(-300);
        ListNode leftEnd = leftHead;
        ListNode rightEnd = rightHead;

        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (head.val < x) {
                leftEnd.next = newNode;
                leftEnd = newNode;
            } else {
                rightEnd.next = newNode;
                rightEnd = newNode;
            }
            head = head.next;
        }


        if (leftEnd.val == -300 && rightEnd.val == -300) {
            return null;
        } else if (leftEnd.val == -300) {
            return rightHead.next;
        } else if (rightEnd.val == -300) {
            return leftHead.next;
        } else {
            leftEnd.next = rightHead.next;
            return leftHead.next;
        }

    }

    public static void main(String[] args) {
        int[] inp = {4, 3, 2, 5, 2};
        ListNode head = new ListNode(1);
        for (int i : inp) {
            ListNode t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new ListNode(i);
        }

        ListNode partition = new Solution().partition(head, 3);
        System.out.println("partition = " + partition);
    }
}
