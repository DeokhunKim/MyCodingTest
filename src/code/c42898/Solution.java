package code.c42898;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// (a % x) + (b % x) = (a + b) % x
// 5%3 + 10%3 = 3

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        boolean[][] isPuddles = new boolean[n + 1][m + 1];
        long[][] visitNum = new long[n + 1][m + 1];
        for (boolean[] booleans : isPuddles) {
            Arrays.fill(booleans, false);
        }
        for (long[] booleans : visitNum) {
            Arrays.fill(booleans, 0L);
        }
        for (int[] puddle : puddles) {
            // 이거 0 1 반대 확인
            isPuddles[puddle[1]][puddle[0]] = true;
        }

        List<int[]> character = new ArrayList<>();
        character.add(new int[]{1, 1});
        visitNum[1][1] = 1;
        long count = 0;
        while (true) {
            List<int[]> nextCharacter = new ArrayList<>();

            for (int[] ints : character) {
                int y = ints[0];
                int x = ints[1];

                //right
                if (x != m && isPuddles[y][x + 1] == false) {
                    if (y == n && x + 1 == m) {
                        count += visitNum[y][x];
                    } else {
                        if (visitNum[y][x + 1] == 0) {
                            nextCharacter.add(new int[]{y, x + 1});
                        }
                        visitNum[y][x + 1] += visitNum[y][x] % 1000000007 ;
                    }
                }
                //down
                if (y != n && isPuddles[y + 1][x] == false ) {
                    if (y + 1 == n && x == m) {
                        count += visitNum[y][x];
                    } else {
                        if (visitNum[y + 1][x] == 0) {
                            nextCharacter.add(new int[]{y + 1, x});
                        }
                        visitNum[y + 1][x] += visitNum[y][x] % 1000000007;
                    }
                }
            }

            if (count != 0) {
                count = (count % 1000000007);
                break;
            }

            character = nextCharacter;

            if (nextCharacter.isEmpty()) {
                // 이거에 대한 설명이 없음
                return 0;
            }
        }

        return (int)count;
    }




    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] p = {{2,2}};
        int solution = new Solution().solution(m, n, p);
        System.out.println("solution = " + solution);
    }
}
