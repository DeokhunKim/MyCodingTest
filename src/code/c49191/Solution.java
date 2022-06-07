package code.c49191;

import java.util.*;

public class Solution {
    Map<Integer, Node> win = new HashMap<>();
    Map<Integer, Node> lose = new HashMap<>();
    public int solution(int n, int[][] results) {
        int answer = 0;

        for (int[] result : results) {
            if (!lose.containsKey(result[0])) {
                lose.put(result[0],new Node());
            }
            lose.get(result[0]).nodes.add(result[1]);
            if (!win.containsKey(result[1])) {
                win.put(result[1],new Node());
            }
            win.get(result[1]).nodes.add(result[0]);
        }

        for (int i = 1; i <= n; i++) {
            int numRankUp = getNumRankUp(i);
            int numRankDown = getNumRankDown(i);
            if (numRankDown + numRankUp != n - 1) {
                continue;
            }
            answer++;
        }

        return answer;
    }

    public class Node {
        List<Integer> nodes = new ArrayList<>();
    }

    public int getNumRankUp(int n) {
        boolean[] isVist = new boolean[100];
        Arrays.fill(isVist, false);
        int count = 0;
        Queue<Integer> wait = new PriorityQueue<>();
        wait.add(n);
        while (wait.size() != 0) {
            int target = wait.poll();
            if (isVist[target] == true) {
                continue;
            }
            isVist[target] = true;
            count++;

            if (!win.containsKey(target)) {
                continue;
            }
            for (int node : win.get(target).nodes) {
                wait.add(node);
            }
        }
        return count - 1;//본인빼고
    }

    public int getNumRankDown(int n) {
        boolean[] isVist = new boolean[101];
        Arrays.fill(isVist, false);
        int count = 0;
        Queue<Integer> wait = new PriorityQueue<>();
        wait.add(n);
        while (wait.size() != 0) {
            int target = wait.poll();
            if (isVist[target] == true) {
                continue;
            }
            isVist[target] = true;
            count++;

            if (!lose.containsKey(target)) {
                continue;
            }
            for (int node : lose.get(target).nodes) {
                wait.add(node);
            }
        }
        return count - 1;//본인빼고
    }


    public static void main(String[] args) {
        int n = 5;
        //int[][] p = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int[][] p = {{1,5}, {2,5}, {3,4}, {4,5}};
        int solution = new Solution().solution(n, p);
        System.out.println("solution = " + solution);
    }

}
