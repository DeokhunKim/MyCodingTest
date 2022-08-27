package leetcode.c363

class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        var maxSum = -100000

        // Step1, store sum of (0,0) to (i,j)
        val sumFromZero = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                // store
                sumFromZero[i][j] = sumFromZero(matrix, i, j)
                // check on the way
                if (k == sumFromZero[i][j]) {
                    return k
                } else if(sumFromZero[i][j] in (maxSum + 1) until k){
                    maxSum = sumFromZero[i][j]
                }
            }
        }

        // Step2, loop sum of (i,j) to (k,l)
        for (u in 0 until m) {
            for (l in 0 until n) {
                for (i in 0 .. u) {
                    for (j in 0 .. l) {
                        // A B
                        // C D
                        // D = ABCD - B - C + A
                        val ABCD = sumFromZero[u][l]
                        val B = if(i != 0) sumFromZero[i-1][l] else 0
                        val C = if(j != 0) sumFromZero[u][j-1] else 0
                        val A = if(i != 0 && j != 0) sumFromZero[i-1][j-1] else 0

                        val D = ABCD - B - C + A
                        // check on the way
                        if (k == D) {
                            return k
                        } else if(D in (maxSum + 1) until k){
                            maxSum = D
                        }

                    }
                }
            }
        }

        return maxSum
    }

    fun sumFromZero(matrix: Array<IntArray>, i: Int, j: Int): Int {
        var sum = 0
        for (a in 0 .. i) {
            for (b in 0 .. j) {
                sum += matrix[a][b]
            }
        }
        return sum
    }
}

fun main() {
    println("1st")
    println(Solution().maxSumSubmatrix(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, 3)), 2)) // 2
    println("2nd")
    println(Solution().maxSumSubmatrix(arrayOf(intArrayOf(2, 2, -1)), 3)) // 3
    println("3rd")
    println(Solution().maxSumSubmatrix(arrayOf(intArrayOf(2, 2, -1)), 0)) // -1
    println("4th")
    println(Solution().maxSumSubmatrix(arrayOf(intArrayOf(5,-4,-3,4), intArrayOf(-3,-4,4,5), intArrayOf(5,1,5,-4)), 10)) // 10


}