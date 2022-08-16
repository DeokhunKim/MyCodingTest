package leetcode.c9

class Solution {
    fun isPalindrome(x: Int): Boolean {
        var s:String = x.toString()

        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - i - 1]) {
                return false
            }
        }
        return true;
    }
}

fun main() {
    val value = Solution().isPalindrome(10);
    println(value);

}