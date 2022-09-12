package leetcode.c948;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        //조금 쓰고, 많이 충전하는 greedy
        Arrays.sort(tokens);
        LinkedList<Integer> list = new LinkedList<>();
        for (int token : tokens) {
            list.add(token);
        }
        int score = 0;
        int maxScore = 0;
        while (!list.isEmpty()) {
            if (list.get(0) <= power) {
                power -= list.getFirst();
                list.removeFirst();
                score++;
                maxScore = Math.max(score, maxScore);
            } else if (score != 0) {
                Integer pop = list.getLast();
                list.removeLast();
                score--;
                power += pop;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().bagOfTokensScore(new int[]{100}, 50) + "/0");
        //System.out.println(new Solution().bagOfTokensScore(new int[]{100,200}, 150) + "/1");
        //System.out.println(new Solution().bagOfTokensScore(new int[]{100,200,300,400}, 200) + "/2");
        System.out.println(new Solution().bagOfTokensScore(new int[]{71,55,82}, 54) + "/0");
    }


}
