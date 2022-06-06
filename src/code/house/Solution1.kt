package code.house

class Solution1 {
    fun solution(path: String): Array<String> {
        val answer: Array<String> = arrayOf<String>()

        var curS = path[0]
        var sNum = 0
        var printIndex = mutableSetOf<Int>()
        var startIndex = 0
        var msgList = mutableListOf<String>()

        for (i in 0 until path.length) {
            if (curS == path[i] /* && i != path.length-1*/) {
                sNum++
            } else {
                var time = 0
                var len = 0
                if (sNum >= 5) {
                    printIndex.add(i - 5)
                    time = i - 5
                    len = 5
                } else {
                    printIndex.add(startIndex)
                    time = startIndex
                    len = sNum
                }
                var LR = getLR(curS.toString(), path[i].toString())
                var msg = "Time ${time}: Go straight ${len}00m and turn ${LR}"
                println(msg)
                msgList.add(msg)


                sNum = 1
                startIndex = i
                curS = path[i]
            }
        }







        return msgList.toTypedArray()
    }
    fun getLR(s: String, e: String): String {
        if (s == "E" && e == "N") {
            return "left"
        }
        else if (s == "E" && e == "S") {
            return "right"
        }
        else if (s == "N" && e == "W") {
            return "left"
        }
        else if (s == "N" && e == "E") {
            return "right"
        }
        else if (s == "W" && e == "S") {
            return "left"
        }
        else if (s == "W" && e == "N") {
            return "right"
        }
        else if (s == "S" && e == "E") {
            return "left"
        }
        else if (s == "S" && e == "W") {
            return "right"
        }
        else {
            return "error"
        }

    }

}

fun main() {
    var answer =
        Solution1().solution("SSSSSSWWWNNNNNN")

    println(answer)
}


