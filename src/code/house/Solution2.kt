package code.house

class Solution2 {
    fun solution(call: String):String{
        var answer:String = ""
        var patternSet = mutableSetOf<String>()

        val lowerCall = call.toLowerCase()

        for (len in 1..lowerCall.length-1) {
            for (index in 0..lowerCall.length - len) {
                var pattern = lowerCall.substring(index, index+len)
                patternSet.add(pattern)
                //println(pattern)
            }
        }


        var maxP = 0
        var maxPList = mutableListOf<String>()
        var removeP = mutableListOf<String>()
        patternLoop@ for (pattern in patternSet) {
            val split = lowerCall.split(pattern)
            //println("${pattern}: ${split} : ${split.size - 1}")
            if (maxP < split.size - 1) {
                maxP = split.size - 1
                maxPList.clear()
                maxPList.add(pattern)
            }
            else if (maxP == split.size - 1) {

                for (c in maxPList) {
                    if (c.contains(pattern)) {
                        continue@patternLoop
                    }
                    else if (pattern.contains(c)) {
                        removeP.add(c)
                    }
                }

                maxPList.add(pattern)
            }
        }

        for (r in removeP) {
            maxPList.remove(r)
        }

        var removeIndexList = mutableListOf<Int>()
        var removeLen = mutableMapOf<Int, Int>()
        for (pattern in maxPList) {
            var index = 0
            while (true) {
                val what = lowerCall.indexOf(pattern, index)
                if (what == -1) {
                    break
                }
                removeIndexList.add(what)
                removeLen.put(what, pattern.length)
                index = what+1
            }
        }

        removeIndexList.sort()
        for (i in removeIndexList) {
            println(i)
        }

        answer = call
        for (i in removeIndexList) {
            println("remove: ${i}, ${i+ removeLen.get(i)!!}, ${answer}")
            var len = removeLen.get(i)!!
            answer = answer.substring(0, i) +
                answer.substring(i+len, answer.length)

            println(answer)
        }



        return answer
    }
}

fun main() {
    var answer =
        Solution2().solution("abxdeydeabz")
        //Solution2().solution("abc abc abc bc")

    println(answer)
}