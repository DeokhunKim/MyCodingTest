package leetcode.c804

class Solution {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val trans:HashMap<Char, String> = HashMap()
        val hashSet:HashSet<String> = HashSet()
        val array = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        var i = 0
        for (c in 'a'..'z') {
            trans[c] = array[i++]
        }

        for (word in words) {
            var str:StringBuilder = StringBuilder()
            for (c in word) {
                str.append(trans[c])
            }
            hashSet.add(str.toString())
        }


        return hashSet.size
    }
}

fun main() {

    var words: Array<String> = arrayOf("gin","zen","gig","msg")
    val uniqueMorseRepresentations = Solution().uniqueMorseRepresentations(words)
    println(uniqueMorseRepresentations)

}