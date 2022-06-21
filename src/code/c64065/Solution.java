package code.c64065;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        // 집합의 사이즈 key - 내용 value 로 저장.
        // 1->n 혹은 n->1 로 순서대로 정답 채워넣기.
        // > 뭐가 나을까?
        // > 10000개 중에 9999개 찾는거 오래걸리지 않을까??
        // 일단 복잡하게 생각하지 말고 구현해볼까?
        // {{2},{2,1},{2,1,3},{2,1,3,4}}
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        Map<Integer, Set<Integer>> combMap = new HashMap<>();

        String s2 = s.substring(1, s.length() - 1);
        String[] split = s2.split("(\\},\\{|\\{|\\})");
        for (String s1 : split) {
            String[] split2 = s1.replaceAll("[{}]","").split(",");
            if(split2[0] == "")
                continue;
            Set<Integer> set = new HashSet<>();
            for (String s3 : split2) {
                set.add(Integer.parseInt(s3));
            }
            combMap.put(split2.length, set);
        }

        Set<Integer> noteSet = new HashSet<>();
        for (Set<Integer> value : combMap.values()) {
            for (Integer integer : value) {
                if (!noteSet.contains(integer)) {
                    noteSet.add(integer);
                    answerList.add(integer);
                    break;
                }
            }
        }

        //System.out.println("answerList = " + answerList.toString());
        answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] solution = new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}
