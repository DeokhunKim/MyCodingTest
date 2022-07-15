package leetcode.c695;

import java.util.*;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int h = 0; h < grid.length; h++) {
            for (int w = 0; w < grid[0].length; w++) {
                if (grid[h][w] == 1) {
                    grid[h][w] = 0;
                    int area = bfs(grid, h, w);
                    if (area > result) {
                        result = area;
                    }
                }
            }
        }

        return result;
    }

    public int bfs(int[][] grid, int h, int w) {
        int area = 1;
        LinkedList<XY> q = new LinkedList<>();
        XY xy = new XY(w, h);
        q.add(xy);

        while (!q.isEmpty()) {
            XY target = q.poll();
            if (target.x != 0) {
                if (grid[target.y][target.x - 1] == 1) {
                    q.add(new XY(target.x - 1, target.y));
                    grid[target.y][target.x - 1] = 0;
                    area++;
                }
            }
            if (target.x != grid[0].length - 1) {
                if (grid[target.y][target.x + 1] == 1) {
                    q.add(new XY(target.x + 1, target.y));
                    grid[target.y][target.x + 1] = 0;
                    area++;
                }
            }
            if (target.y != 0) {
                if (grid[target.y - 1][target.x] == 1) {
                    q.add(new XY(target.x, target.y - 1));
                    grid[target.y - 1][target.x] = 0;
                    area++;
                }
            }
            if (target.y != grid.length - 1) {
                if (grid[target.y + 1][target.x] == 1) {
                    q.add(new XY(target.x, target.y + 1));
                    grid[target.y + 1][target.x] = 0;
                    area++;
                }
            }
        }
        return area;
    }

    public class XY {
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }


    public static void main(String[] args) {

        int[][] inp = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int i = new Solution().maxAreaOfIsland(inp);

        System.out.println("i = " + i);

    }
}
