package code.c62048

import kotlin.math.ceil
import kotlin.math.floor

class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        // y = ax + b
        // y = h/wx = y = 4/3x
        var a = h.toDouble() / w.toDouble()
        var sy:Long = 0
        var sum:Long = 0
        for (width in 0..w) {
            var y = h.toDouble() * width / w.toDouble()
            //var y = a * width
            var upy = ceil(y)
            sum += (upy.toLong() - sy)
            var downy = floor(y)
            sy = downy.toLong()
            //println("+${sum}, x:${width}, y:${y}")
            //println("y:${y}, upy:${upy}, downy${downy}")
        }

        answer = w.toLong() * h.toLong() - sum

        return answer
    }
}


fun main() {
    //100000000
    //999999999
    val answer = Solution().solution(100000, 999999)
    println(answer)
}