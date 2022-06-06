package code.c43238

class Solution {

    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var nn:Long = n.toLong()

        var preTime = 0L
        var postTime = 1000000000000000000L
        var checkTime = (postTime + preTime) / 2
        while (preTime != postTime) {
            var passed = 0L
            for (time in times) {
                passed += checkTime / time.toLong()
            }

            var isBig = passed >= nn

            if (postTime - preTime == 1L) {
                for (time in times) {
                    passed += preTime / time.toLong()
                }
                if (passed == nn) {
                    checkTime = preTime
                    break
                } else {
                    checkTime = postTime
                    break
                }
            }

            if (isBig) {
                postTime = checkTime
            } else {
                preTime = checkTime
            }
            checkTime = (postTime + preTime) / 2
            println("${preTime}, ${postTime}")
        }

        answer = checkTime

        for (time in times) {
            var passed = checkTime / time
            println("${time}분 걸리는 심사관 ${passed}명 (${time*passed}분에 끝)")
        }

        println(answer)
        return answer
    }
}

fun main() {
    var a = Solution()
    a.solution(1000000000, intArrayOf(1000000000, 1000000000, 1000000000))
}