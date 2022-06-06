package code.house

class Solution3 {
    fun solution(tstring: String, variables: Array<Array<String>>): String {
        var answer = "aa"
        var templateMap = mutableMapOf<String, String>()
        for (variable in variables) {
            templateMap.put(variable[0], variable[1])
        }

        var originMap = templateMap.toMutableMap()
        var replaceMap = templateMap.toMutableMap()
        var isChage = true
        var cnt = 0
        while(isChage){
            if (cnt++ > 10000) {
                break
            }
            templateMap = replaceMap.toMutableMap()
            //println(replaceMap.toString())
            isChage = false
            for (template in templateMap) {
                //println("${template.value} is ${isTemplate(template.value)}")

                if (!isTemplate(template.value)) {
                    continue
                }

                //println("${template.value} is ${getContent(template.value)}")
                val replaceStr = templateMap.getOrDefault(getContent(template.value), null)
                if (replaceStr == null || replaceStr == template.value) {
                    continue
                }

                replaceMap[template.key] = replaceStr
                isChage = true

                if(cnt > 100000){
                    replaceMap[template.key] = originMap.getOrDefault(template.key, "")
                }

                //println(replaceMap.toString())
            }
        }

        for (template in replaceMap) {
            if (isTemplate(template.value)) {
                continue
            }
            templateMap[template.key] = template.value
        }

        println(templateMap.toString())
        println(replaceMap.toString())

        answer = tstring

        for (template in templateMap) {
            //if (isTemplate(template.value)) {
                //continue
           // }
            answer =
                answer.replace("{${template.key}}", "${template.value}")

            //println("replace {${template.key}} to ${template.value}")
            //println(answer)

        }








        return answer
    }
    fun isTemplate(s: String): Boolean {
        if (s[0] == '{' && s[s.length - 1] == '}') {
            return true
        }
        return false
    }
    fun getContent(s: String): String {
        return s.substring(1, s.length-1)
    }
}

fun main() {
    var tstring1 = "{a} {b} {c} {d} {i}"
    var tstring2 = "this is {template}\n {template} is {state}"

    var variables1 =
        arrayOf(arrayOf("b", "{c}"),
        arrayOf("a", "{b}"),
        arrayOf("e", "{f}"),
        arrayOf("h", "i"),
        arrayOf("d", "{e}"),
        arrayOf("f", "{d}"),
        arrayOf("c", "d")
        )

    var variables2 =
        arrayOf(arrayOf("template", "{state}"),
            arrayOf("state", "{template}")
            //arrayOf("string", "{template}"),
            //arrayOf("a", "{b}") ,
            //arrayOf("b", "{c}") ,
            //arrayOf("c", "d") ,
            //arrayOf("e", "{e}"),
            //arrayOf("f", "g")
        )

    var answer =
        Solution3().solution(tstring1, variables1)

    println(answer)
}