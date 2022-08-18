package leetcode.c1338

import kotlin.math.min

class Solution {
    fun minSetSize(arr: IntArray): Int {
        var size = IntArray(100001, {0} )
        for (i in arr) {
            size[i]++
        }

        size.sortDescending()

        var sum = 0
        var count = 0
        for (i in size) {
            sum += i
            count++
            if (sum >= arr.size / 2) {
                return count
            }
        }

        return 0
    }
}

fun main() {
    val arr:IntArray = intArrayOf(7,7,7,7)

    val minSetSize = Solution().minSetSize(arr)
    println(minSetSize)


}