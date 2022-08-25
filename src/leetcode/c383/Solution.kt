package leetcode.c383

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        var map = HashMap<Char, Int>()
        for (c in 'a'..'z') {
            map[c] = 0
        }

        for (c in magazine) {
            map[c] = map[c]!! + 1
        }

        for (c in ransomNote) {
            if (map[c] == 0) {
                return false
            }
            map[c] = map[c]!! - 1
        }

        return true
    }
}

fun main() {
    var a1 = "rlaejrgns"
    var b1 = "sgndsdejvrrflvda"
    var b2 = "sgndsdjvrrflvda"

    println(Solution().canConstruct(a1, b1))
    println(Solution().canConstruct(a1, b2))

}