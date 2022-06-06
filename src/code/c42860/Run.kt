package code.c42860

import java.util.Random
import kotlin.math.min
//13,18,20,22,24,25,27
class Solution {
    fun solution(name: String): Int {
        var answer = 0

        // 좌우 갯수 구하고
        // 1. 좌측으로 출발했다가 우측으로 돌아오거나 안돌아 오는 경우
        // 2. 우측으로 출발했다가 좌측으로 돌아오거나 안돌아 오는 경우

        var rMove = getMinMove(name)
        var reverseName = name.reversed()
        val firstChar = reverseName.get(reverseName.length-1)
        reverseName = firstChar + reverseName.substring(0, reverseName.length-1)
        //println(reverseName)
        // A B C D E -> E D C B A -> A E D C B
        var lMove = getMinMove(reverseName)
        var minMove = min(rMove, lMove)
        //println("minMove: ${minMove}")

        // 상하 갯수 구하고
        var sum = 0
        for (s in name) {
            var score = getScoreFromABC(s)
            sum += score
        }
        //println("score: ${sum}")

        // 출력
        answer = minMove + sum

        return answer
    }

    private fun getScoreFromABC(str: Char): Int{
        when (str) {
            'A' -> return 0
            'B' -> return 1
            'C' -> return 2
            'D' -> return 3
            'E' -> return 4
            'F' -> return 5
            'G' -> return 6
            'H' -> return 7
            'I' -> return 8
            'J' -> return 9
            'K' -> return 10
            'L' -> return 11
            'M' -> return 12
            'N' -> return 13
            'O' -> return 12
            'P' -> return 11
            'Q' -> return 10
            'R' -> return 9
            'S' -> return 8
            'T' -> return 7
            'U' -> return 6
            'V' -> return 5
            'W' -> return 4
            'X' -> return 3
            'Y' -> return 2
            'Z' -> return 1

            else -> return 0
        }

    }


    private fun getMinMove(name: String): Int {
        var minMove = Int.MAX_VALUE
        var notASet = mutableSetOf<Int>()
        for (c in 0 until name.length) {
            if (name[c] != 'A') {
                notASet.add(c)
            }
        }
        var minMove1 = minMove
        var rCheck = 0
        var rCheckSet = notASet.toMutableSet()
        for (r in 0 until name.length) {
            if (rCheckSet.contains(r)) {
                rCheck++
                rCheckSet.remove(r)
            }

            if (rCheck == notASet.size) {
                var sumMove = r
                //println("-> ${r}, <- ${lMove}")
                if (sumMove < minMove1) {
                    minMove1 = sumMove
                    //println("-> ${r}, <- 0")
                }
                continue
            }


            var l = r - 1
            var lCheck = 0
            var lMove = 1
            var lCheckSet = rCheckSet.toMutableSet()
            if (l < 0) {
                l = name.length - 1
            }
            while (l != r) {
                //println("r:${r},l:${l}")
                if (lCheckSet.contains(l)) {
                    lCheck++
                    lCheckSet.remove(l)
                }

                if (rCheck + lCheck == notASet.size) {
                    var sumMove = r + lMove
                    //println("-> ${r}, <- ${lMove}")
                    if (sumMove < minMove1) {
                        minMove1 = sumMove
                        //println("-> ${r}, <- ${lMove}")
                    }
                    break
                }
                l--
                lMove++
                if (l < 0) {
                    l = name.length - 1
                }
            }
        }
        return minMove1
    }
}


fun main() {
    val random = kotlin.random.Random(3)
    var answer:Int

    for (i in 0..30) {
        val strLen = random.nextInt(5, 19)
        var str:String = ""
        for (c in 0..strLen) {
            val randNum = random.nextInt(0, 26)
            val isA = random.nextInt(1, 3)
            if (isA != 1) {
                var randABC = 'A' + randNum
                str += randABC
            } else {
                str += 'A'
            }

        }
        //println(str)
        answer = Solution().solution(str)

        println("input:${str} / answer:${answer}")



    }


   // answer = Solution().solution("BBBBAAAABA")
    //var answer = Solution().solution("ABCDE")


    //println(answer)


}