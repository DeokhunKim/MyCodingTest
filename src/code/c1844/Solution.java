package code.c1844;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int solution(int[][] maps) {
        int answer = 0;
        int height = maps.length;
        int width = maps[0].length;
        boolean[][] visit = new boolean[height][width];
        for (boolean[] booleans : visit) {
            Arrays.fill(booleans, false);
        }

        List<int[]> character = new ArrayList<>();
        character.add(new int[]{0,0});
        visit[0][0] = true;
        int count = 1;
        while (true) {
            count++;
            List<int[]> nextCharacter = new ArrayList<>();
            for (int[] ints : character) {
                int x = ints[1];
                int y = ints[0];

                if (y != 0 && isAvailMove(x, y - 1, maps, visit)) { //up
                    move(x, y - 1, visit);
                    nextCharacter.add(new int[]{y - 1, x});
                }
                if (y != height - 1 && isAvailMove(x, y + 1, maps, visit)) { //down
                    move(x, y + 1, visit);
                    nextCharacter.add(new int[]{y + 1, x});
                }
                if (x != 0 && isAvailMove(x - 1, y, maps, visit)) { //left
                    move(x - 1, y, visit);
                    nextCharacter.add(new int[]{y, x - 1});
                }
                if (x != width - 1 && isAvailMove(x + 1, y, maps, visit)) { //right
                    move(x + 1, y, visit);
                    nextCharacter.add(new int[]{y, x + 1});
                }

            }

            if (nextCharacter.isEmpty()) {
                return -1;
            }

            for (int[] check : nextCharacter) {
                if (check[0] == height - 1 && check[1] == width - 1) {
                    return count;
                }
            }
            character = nextCharacter;

            if (count == 5) {
                System.out.println("nextCharacter = " + nextCharacter);
            }


        }


    }
    public boolean isAvailMove(int x, int y, int[][] maps, boolean[][] visit) {
        if (visit[y][x] == true) {
            return false;
        }
        if (maps[y][x] == 0) {
            return false;
        }
        return true;
    }
    public void move(int x, int y,  boolean[][] visit) {
        visit[y][x] = true;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1,1,1,1,1,1,1},
                {1,0,1,0,1,1,1},
                {1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1},
                {0,0,0,1,1,0,1}};
        int solution = new Solution().solution(input);
        System.out.println("solution = " + solution);
    }
}
