package code.c81301;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> dicMap = new HashMap<>();

        dicMap.put( "zero"  ,"0");
        dicMap.put(	"one"   ,"1");
        dicMap.put(	"two"   ,"2");
        dicMap.put(	"three" ,"3");
        dicMap.put(	"four"  ,"4");
        dicMap.put(	"five"  ,"5");
        dicMap.put(	"six"   ,"6");
        dicMap.put(	"seven" ,"7");
        dicMap.put(	"eight" ,"8");
        dicMap.put(	"nine"  ,"9");

        for (String key : dicMap.keySet()) {
            s = s.replaceAll(key, dicMap.get(key));
        }

        answer = Integer.parseInt(s);
        System.out.println("answer = " + answer);

        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("2three45sixseven");


    }

}