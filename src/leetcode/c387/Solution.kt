package leetcode.c387

class Solution {
    fun firstUniqChar(s: String): Int {
        var set:HashSet<Char> = HashSet()
        var uniqueSet:HashSet<Char> = HashSet()

        for (i in 0 until s.length) {
            if (set.add(s[i])) {
                uniqueSet.add(s[i])
            } else {
                uniqueSet.remove(s[i])
            }
        }

        for (i in 0 until s.length) {
            if (uniqueSet.contains(s[i])) {
              return i
            }
        }

        return -1
    }

}

fun main() {
    val s = "loveleetcode"
    val firstUniqChar = Solution().firstUniqChar(s)
    println(firstUniqChar)

}

