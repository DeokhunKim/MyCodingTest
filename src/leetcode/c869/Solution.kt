package leetcode.c869

class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        var sb = StringBuilder()
        val ns = n.toString().toList().sorted()
        for (n in ns) {
            sb.append(n)
        }
        val find = sb.toString()

        var k = 1
        val max = 1000000000
        var power2 = HashSet<String>()
        while(true) {
            if (k >= max) {
                break
            }
            sb.clear()
            val sorted = k.toString().toList().sorted()
            for (c in sorted) {
                sb.append(c)
            }
            power2.add(sb.toString())
            k *= 2
        }

        if (power2.contains(find)) {
            return true
        }

        return false
    }
}

fun main() {

    println(Solution().reorderedPowerOf2(10))
    println(Solution().reorderedPowerOf2(1))

}