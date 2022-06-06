package code.t

class Solution2 {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        var cnt = 1
        var board = mutableListOf<MutableList<Int>>()
        for (h in 0 until rows) {
            var wList = mutableListOf<Int>()
            for (w in 0 until columns) {
                wList.add(cnt++)
            }
            board.add(wList)
        }

        for (b in board) {
           // println(b)
        }
        for (query in queries) {
            var minX = query[1]
            var minY = query[0]
            var maxX = query[3]
            var maxY = query[2]

            var originLoc = arrayOf(minX, minY)
            var startLoc = arrayOf(minX, minY)
            var nextLoc = arrayOf(minX+1, minY)
            var curNum = board[startLoc[1]-1][startLoc[0]-1]
            var minVal = curNum
            while (true) {
                //curNum = board[startLoc[1]-1][startLoc[0]-1]
                var nextNum = 0
                //println(curNum)
                //->
                if (startLoc[1] == minY && startLoc[0] != maxX) {
                    nextLoc = arrayOf(startLoc[0] + 1 , startLoc[1])
                }
                // 아래
                else if (startLoc[0] == maxX && startLoc[1] != maxY) {
                    nextLoc = arrayOf(startLoc[0]  , startLoc[1]+1)
                } // <-
                else if (startLoc[1] == maxY && startLoc[0] != minX) {
                    nextLoc = arrayOf(startLoc[0] - 1 , startLoc[1])
                }
                // 위
                else if (startLoc[0] == minX && startLoc[1] != minY) {
                    nextLoc = arrayOf(startLoc[0] , startLoc[1] -1)
                }
                else {
                    println("에러")
                }
                nextNum = board[nextLoc[1]-1][nextLoc[0]-1]
                if (minVal > nextNum) {
                    minVal = nextNum
                }

                board[nextLoc[1]-1][nextLoc[0]-1] = curNum
                curNum = nextNum
                startLoc = nextLoc


                if (originLoc[0] == nextLoc[0] && originLoc[1] == nextLoc[1]) {
                    answer.add(minVal)
                    break
                }

            }


        }




        return answer.toIntArray()
    }
}

fun main2() {
    var answer = Solution2().solution(6,6,
        arrayOf(arrayOf(2, 2, 5, 4).toIntArray(),
            arrayOf(3, 3, 6, 6).toIntArray(),
            arrayOf(5, 1, 6, 3).toIntArray()))

    for (a in answer) {
        println(a)
    }
}


class Solution { //68936
    var sum0 = 0
    var sum1 = 0

    var some = Array(5, {IntArray(3,{0})})

    fun solution(arr: Array<IntArray>): IntArray {


        var answer: IntArray = intArrayOf()

        var newArray = mutableListOf<MutableList<Int>>()
        for (h in 0 until arr.size) {
            newArray.add(mutableListOf())
        }

        for (h in 0 until arr.size) {
            for (w in 0 until arr[0].size) {
                newArray[h].add(arr[h][w])
            }
        }


        var sNum = newArray[0][0]
        var isChange = false
        for (h in 0 until newArray.size) {
            for (w in 0 until newArray[0].size) {
                if (sNum != newArray[h][w]) {
                    isChange = true
                }
            }
        }
        if (!isChange) {
            if (sNum == 0) {
                sum0++
                //println("${newArray.toString()} 0++")
            } else {
                //println("${newArray.toString()} 1++")
                sum1++
            }
        } else {
            recu(newArray)
        }




        answer = arrayOf(sum0, sum1).toIntArray()


        return answer
    }

    fun recu(arr: MutableList<MutableList<Int>>) {
        var height = arr.size
        var width = arr[0].size
        var sNum = 0
        var isChange = false
        var newArray = mutableListOf<MutableList<Int>>()
        var lowW = 0
        var lowH = 0

        ////////
        for (h in 0 until height / 2) {
            newArray.add(mutableListOf())
        }
        for (h in 0 until height / 2) {
            for (w in 0 until width / 2) {
                newArray[h].add(arr[h][w])
            }
        }

        sNum = newArray[0][0]
        isChange = false
        for (h in 0 until newArray.size) {
            for (w in 0 until newArray[0].size) {
                if (sNum != newArray[h][w]) {
                    isChange = true
                }
            }
        }
        if (isChange) {
            recu(newArray)
        } else {
            if (sNum == 0) {
                sum0++
                //println("${newArray.toString()} 0++")
            } else {
                //println("${newArray.toString()} 1++")
                sum1++
            }
        }




        newArray.clear()


        ////////
        lowH = 0
        for (h in 0 until height / 2) {
            newArray.add(mutableListOf())
        }
        for (h in height / 2 until height ) {
            for (w in 0 until width / 2) {
                newArray[lowH].add(arr[h][w])
            }
            lowH++
        }
        sNum = newArray[0][0]
        isChange = false
        for (h in 0 until newArray.size) {
            for (w in 0 until newArray[0].size) {
                if (sNum != newArray[h][w]) {
                    isChange = true
                }
            }
        }
        if (isChange) {
            recu(newArray)
        } else {
            if (sNum == 0) {
                sum0++
                //println("${newArray.toString()} 0++")
            } else {
                //println("${newArray.toString()} 1++")
                sum1++
            }
        }
        newArray.clear()



        ////////
        lowH = 0
        for (h in 0 until height / 2) {
            newArray.add(mutableListOf())
        }
        for (h in 0 until height / 2) {
            for (w in width / 2 until width) {
                newArray[lowH].add(arr[h][w])
            }
            lowH++
        }
        sNum = newArray[0][0]
        isChange = false
        for (h in 0 until newArray.size) {
            for (w in 0 until newArray[0].size) {
                if (sNum != newArray[h][w]) {
                    isChange = true
                }
            }
        }
        if (isChange) {
            recu(newArray)
        } else {
            if (sNum == 0) {
                sum0++
                //println("${newArray.toString()} 0++")
            } else {
                //println("${newArray.toString()} 1++")
                sum1++
            }
        }
        newArray.clear()



        ////////
        lowH = 0
        for (h in 0 until height / 2) {
            newArray.add(mutableListOf())
        }
        for (h in height / 2 until height ) {
            for (w in width / 2 until width) {
                newArray[lowH].add(arr[h][w])
            }
            lowH++
        }
        sNum = newArray[0][0]
        isChange = false
        for (h in 0 until newArray.size) {
            for (w in 0 until newArray[0].size) {
                if (sNum != newArray[h][w]) {
                    isChange = true
                }
            }
        }
        if (isChange) {
            recu(newArray)
        } else {
            if (sNum == 0) {
                sum0++
                //println("${newArray.toString()} 0++")
            } else {
                //println("${newArray.toString()} 1++")
                sum1++
            }
        }
        newArray.clear()


    }



}

fun main() {
    var answer = Solution().solution(
        arrayOf(arrayOf(0,0,0,0).toIntArray(),
            arrayOf(0,0,0,0).toIntArray(),
            arrayOf(0,0,0,0).toIntArray(),
            arrayOf(0,0,0,0).toIntArray()))

    for (a in answer) {
        println(a)
    }
}