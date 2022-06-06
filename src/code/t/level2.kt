package code.t

import java.util.Stack

class level2 {
    fun solution(s: String): Int {
        var answer: Int = 0

        var str = s
        for (i in 0 until s.length) {

            str = str[s.length-1] + str.substring(0, s.length-1)
            if (isCorrect(str)) {
                answer++
            }
        }


        return answer
    }
    fun isCorrect(str: String): Boolean {
        var stack = Stack<Char>()

        for (c in str) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c)
            } else {
                if (stack.empty()) {
                    return false
                }
                val pop = stack.pop()
                if (( c == ')' && pop == '(')
                    || ( c == '}' && pop == '{')
                    || ( c == ']' && pop == '[') ) {

                } else {
                    return false
                }
            }
        }

        return stack.empty()

    }
}

class level22 {
    fun solution(line: Array<IntArray>): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        var points = mutableSetOf<IntArray>()
        for (i in 0 until line.size) {
            for (j in i until line.size - 1) {
                var line1 = line[i]
                var line2 = line[j]

                if (line1[0] * line2[1] - line1[1] * line2[0] == 0) {
                    continue
                }

                val crossPoint = cross(line1, line2)
                points.add(crossPoint)
            }
        }

        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE

        points.forEach { i ->
            if (i[0] < minX) {
                minX = i[0]
            }
            if (i[0] > maxX) {
                maxX = i[0]
            }
            if (i[1] < minY) {
                minY = i[1]
            }
            if (i[1] > maxY) {
                maxY = i[1]
            }
        }

        var width = maxX - minX + 1
        var height = maxY - minY + 1

        for (p in points) {
            println("${p[0]}, ${p[1]}")
        }

        var cnt = 0
        var temp = mutableListOf<String>()
        for (h in 0..height) {
            var str = ""
            for (w in 0..width) {
                var x = w + minX
                var y = h + minY
                println("x${x}, y${y}")
                if (points.contains(arrayOf(x, y).toIntArray())) {
                    str += "*"
                } else {
                    str += "."
                }
            }
            temp.add(str)
        }

        answer = temp.toTypedArray()
        return answer
    }

    fun cross(line1: IntArray, line2: IntArray): IntArray {
        var A = line1[0]
        var B = line1[1]
        var C = line2[0]
        var D = line2[1]
        var E = line1[2]
        var F = line2[2]

        var x = (B * F - E * D) / (A * D - B * C)
        var y = (E * C - A * F) / (A * D - B * C)

        return arrayOf(x,y).toIntArray()
    }


}


fun main() {
    var temp1: IntArray = arrayOf(2, -1, 4).toIntArray()
    var temp2: IntArray = arrayOf(-22, -1, 4).toIntArray()
    var temp3: IntArray = arrayOf(0, -1, 1).toIntArray()
    var temp4: IntArray = arrayOf(5, -8, -12).toIntArray()
    var temp5: IntArray = arrayOf(5, 8, 12).toIntArray()



    val aaa = arrayOf(temp1, temp2, temp3, temp4, temp5)
    var answer = level22().solution(aaa)
    for (s in answer) {
        println(s)
    }
}