package code.c42895



class Solution {
    var N:Int = 0
    var LINIT:Int = 8
    var dp = mutableMapOf<String, Int>()
    var isCheck = mutableSetOf<String>()
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        this.N = N

        dp.put("(" + N.toString() + ")", N)
        dp.put("(" + N.toString() + N.toString() + ")", N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + ")", N*100+N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + N.toString() + ")", N*1000+N*100+N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + N.toString() + N.toString() + ")", N*10000+N*1000+N*100+N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + N.toString()
                + N.toString() + N.toString() + ")", N*100000+N*10000+N*1000+N*100+N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + N.toString()
                + N.toString() + N.toString() + N.toString() + ")", N*1000000+N*100000+N*10000+N*1000+N*100+N*10+N)
        dp.put("(" + N.toString() + N.toString() + N.toString() + N.toString()
                + N.toString() + N.toString() + N.toString() + N.toString() + ")", N*10000000+N*1000000+N*100000+N*10000+N*1000+N*100+N*10+N)


        // 1. A

        // 2. A?A
        // 2. AA

        // 3. A?2
        // 3. 2?A
        // 3. AAA

        // 4. A?3
        // 4. 3?A
        // 4. 2?2
        // 4. AAAA (가중치 4)

        // 5. AAAAA (가중치 5)
        // 5. A?4
        // 5. 4?A
        // 5. 3?2
        // 5. 2?3

        // 6. AAAAAA (가중치 6)
        // 6. A?5
        // 6. 5?A
        // 6. 4?2
        // 6. 3?3
        // 6. 2?4

        // 7. AAAAAAA
        // 7. 6?A
        // 7. 5?2
        // 7. 4?3
        // 7. 3?4
        // 7. 2?5
        // 7. A?6



        //1. A              22

        //2-1. A ? A        2+2 2-1 2*2 2/2
        //2-2. AA           22

        //3-1. A ? 2-1      2+2+2 2-2+
        //3-2. A ? 2-2
        //3-3. 2-1 ? A
        //3-4. 2-1 ? 2-1
        //3-5. 2-1 ? 2-2





        return answer
    }

    fun recu(str1: String, str2: String, deep1: Int) {
        // 한 건지 체크
        var checkStr = str1 + "," + str2
        if (isCheck.contains(checkStr)) {
            return
        }
        isCheck.add(checkStr)

        // str을 map을통해 숫자로 변환
        var num1:Int = dp.getOrDefault(str1,0)
        var num2:Int = dp.getOrDefault(str1,0)

        // str ? str
        var newNum = IntArray(8,{0})
        var newStr = Array<String>(8,{""})
        newStr[0] = "(" + str1 + "+" + str2 + ")"
        newNum[0] = num1 + num2
        newStr[1] = "(" + str1 + "-" + str2 + ")"
        newNum[1] = num1 - num2
        newStr[2] = "(" + str1 + "*" + str2 + ")"
        newNum[2] = num1 * num2
        newStr[3] = "(" + str1 + "/" + str2 + ")"
        newNum[3] = (num1 / num2).toInt()

        newStr[4] = "(" + str2 + "+" + str1 + ")"
        newNum[4] = num2 + num1
        newStr[5] = "(" + str2 + "-" + str1 + ")"
        newNum[5] = num2 - num1
        newStr[6] = "(" + str2 + "*" + str1 + ")"
        newNum[6] = num2 * num1
        newStr[7] = "(" + str2 + "/" + str1 + ")"
        newNum[7] = (num2 / num1).toInt()


        for (i in 0..3) {
            if (newNum[i] < 1 || newNum[i] > 32000) {
                continue //문제 제약사항
            }
            dp.put(newStr[i], newNum[i])


        }

    }


}

fun main() {
    var answer = Solution().solution(5, 12)
    println("answer: ${answer}")

}