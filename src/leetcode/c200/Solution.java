package leetcode.c200;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                visit[i][j] = grid[i][j] == '0' ? true : false;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visit[i][j] == true) {
                    continue;
                }
                searchIsland(h, w, visit, i, j);
                result++;
            }
        }


        return result;
    }

    private void searchIsland(int h, int w, boolean[][] visit, int i, int j) {
        List<Integer> x_wait = new ArrayList<>();
        List<Integer> y_wait = new ArrayList<>();
        y_wait.add(i);
        x_wait.add(j);
        while (x_wait.size() != 0) {
            List<Integer> x_next = new ArrayList<>();
            List<Integer> y_next = new ArrayList<>();
            for (int k = 0; k < x_wait.size(); k++) {
                int x = x_wait.get(k);
                int y = y_wait.get(k);

                // left
                if (x != 0 && !visit[y][x - 1]) {
                    x_next.add(x - 1);
                    y_next.add(y);
                    visit[y][x - 1] = true;
                }

                // right
                if (x != w - 1 && !visit[y][x + 1]) {
                    x_next.add(x + 1);
                    y_next.add(y);
                    visit[y][x + 1] = true;
                }

                // up
                if (y != 0 && !visit[y - 1][x]) {
                    x_next.add(x);
                    y_next.add(y - 1);
                    visit[y - 1][x] = true;
                }

                // down
                if (y != h - 1 && !visit[y + 1][x]) {
                    x_next.add(x);
                    y_next.add(y + 1);
                    visit[y + 1][x] = true;
                }
            }
            x_wait = x_next;
            y_wait = y_next;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'} }));
    }
}
