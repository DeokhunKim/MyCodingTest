package leetcode.c342

class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        var i = n
        if (i < 1) {
            return false
        }
        while (i > 1) {
            if (0 != i % 4) {
                return false
            }
            i /= 4
        }

        return true
    }
}

fun main() {

    println(Solution().isPowerOfFour(16))
    println(Solution().isPowerOfFour(5))
    println(Solution().isPowerOfFour(1))
    println(Solution().isPowerOfFour(-4))
}