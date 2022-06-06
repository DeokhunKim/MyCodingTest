package code.c43236

import java.util.Collections

class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0

        // 0 2 11 14 17 21 25
        // 2 9 3 3 4 4

        // 0 11 14 17 21 25
        // 11 3 3 4 4

        // 0 11 17 21 25
        // 11 6 4 4

        // 0 11 14 21 25
        // 11 3 7 4

        // 0 3 10 15
        // 3 7 5

        rocks.sort()

        var leftRock = 0
        var lenList = mutableListOf<Int>()
        for (rock in rocks) {
            lenList.add(rock - leftRock)
            leftRock = rock
        }
        lenList.add(distance - rocks.last())
        println(lenList)

        for (N in 1..n) {
            var minLen = Collections.min(lenList)
            var minIndex = 0
            var minVal = distance
            for (i in 0 until lenList.size - 1) {
                if (lenList[i] != minLen) {
                    continue
                }
                if (lenList[i + 1] < minVal) {
                    minVal = lenList[i + 1]
                    minIndex = i
                }
            }

            lenList[minIndex + 1] += lenList[minIndex]
            lenList.removeAt(minIndex)
            println(lenList)
        }

        answer = Collections.min(lenList)



        return answer
    }

}

fun main() {
    //var answer = Solution().solution(18, intArrayOf(2, 8, 9, 10, 11, 12, 13), 6)
    var answer = Solution().solution(18, intArrayOf(2, 8, 9, 10, 11, 12, 13), 6)

    println("정답: ${answer}")
}