package leetcode.c1329

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val h = mat.size - 1
        val w = mat[0].size - 1
        var x = 0
        var y = h
        var result = mat

        // loop each matrix diagonal
        while (x != w + 1) {
            // Step 1. find matrix diagonal list
            var i = x
            var j = y
            var list = ArrayList<Int>()
            while (j != h + 1 && i != w + 1) {
                list.add(mat[j][i])
                j++
                i++
            }

            // Step 2. sort list
            list.sort()

            // Step 3. store new matrix to sorted value
            i = x
            j = y
            for (value in list) {
                result[j][i] = value
                j++
                i++
            }

            if (y == 0) {
                x++
            } else {
                y--
            }
        }

        return result
    }
}

fun main() {
    println(Solution().diagonalSort(arrayOf(intArrayOf(11,25,66,1,69,7), intArrayOf(23,55,17,45,15,52), intArrayOf(75,31,36,44,58,8),
        intArrayOf(22,27,33,25,68,4), intArrayOf(84,28,14,11,5,50))))
    println()
    println(Solution().diagonalSort(arrayOf(intArrayOf(3, 3, 1, 1), intArrayOf(2, 2, 1, 2), intArrayOf(1, 1, 1, 2))))
    println()
    println(Solution().diagonalSort(arrayOf(intArrayOf(37,98,82,45,42))))
    println()


}

