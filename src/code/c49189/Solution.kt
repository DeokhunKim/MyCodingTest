package code.c49189

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        //넓이 우선 탐색
        var isVisit:MutableSet<Int> = mutableSetOf(1)
        var graphMap = mutableMapOf<Int, MutableList<Int>>()
        for (line in edge) {
            if (graphMap.contains(line[0])) {
                graphMap.get(line[0])?.add(line[1])
            } else {
                graphMap.put(line[0], mutableListOf(line[1]))
            }
            if (graphMap.contains(line[1])) {
                graphMap.get(line[1])?.add(line[0])
            } else {
                graphMap.put(line[1], mutableListOf(line[0]))
            }
        }

        for (i in graphMap) {
            //println(i.toString())
        }

        var nextNode = mutableListOf<Int>(1)
        var lastSum = 0
        while (isVisit.size != n) {
            lastSum = 0
            var curNode = mutableListOf<Int>()
            for (n in nextNode) {
                val ableNodes = graphMap.get(n)
                for (a in ableNodes!!) {
                    if (isVisit.contains(a)) {
                        continue //이미 방문도니거면 패스
                    } else {
                        curNode.add(a)
                        isVisit.add(a)
                        lastSum++
                    }
                }
            }

            nextNode = curNode
        }

        answer = lastSum
        return answer
    }

}

fun main() {
    var aa: Array<IntArray> = arrayOf(
        arrayOf(3, 6).toIntArray(),
        arrayOf(4, 3).toIntArray(),
        arrayOf(3, 2).toIntArray(),
        arrayOf(1, 3).toIntArray(),
        arrayOf(1, 2).toIntArray(),
        arrayOf(2, 4).toIntArray(),
        arrayOf(5, 2).toIntArray()
    )


    var answer = Solution().solution(6, aa)
    println(answer)
}