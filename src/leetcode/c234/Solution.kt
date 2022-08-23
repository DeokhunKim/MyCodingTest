package leetcode.c234

import leetcode._klib.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var cnt = 0
        var list = head
        while (list != null) {
            cnt++
            list = list.next
        }

        list = head
        var stack = ArrayList<Int>()
        for (i in 0 until cnt / 2) {
            stack.add(list?.`val`!!)
            list = list.next
        }
        if (cnt % 2 != 0) {
            list.let { list = list?.next }
        }
        for (i in 0 until cnt / 2) {
            if (stack[cnt / 2 - i - 1] != list?.`val`!!) {
                return false
            }
            list = list?.next
        }

        return true
    }
}

fun main() {
    var head = ListNode(1)
   // head.next = ListNode(2)
   // head.next?.next = ListNode(3)
   // head.next?.next?.next = ListNode(2)
   // head.next?.next?.next?.next = ListNode(1)
    Solution().isPalindrome(head)

}