package leetcode.c326

class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        var k = n
        while (k > 0) {
            if (k == 1) {
                return true
            } else if (k % 3 != 0) {
                return false
            }
            k /= 3
        }

        return false
    }
}

fun main(){
    println(Solution().isPowerOfThree(24))

}