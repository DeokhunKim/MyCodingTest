package leetcode.c417;


import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //순차 순회 하면서 탐색하고 0, 1, 2, 3 체크 (0은 알수없음, 1은 태평, 2는 대서, 3은 둘다)
        //다음 순회 하다가 0이면 계속 탐색, 1, 2, 3 만나면 탐색 종료하고 가능한 케이스에 저장, 케이스가 3이 되면 더이상 탐색 할 필요 없음.
        int h = heights.length;
        int w = heights[0].length;

        Map<Pair, Integer> map = new HashMap();
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!map.containsKey(new Pair(i, j))) {
                    set.add(new Pair(i, j));
                    map.put(new Pair(i, j), getFlag(heights, map, i, j, set));
                    set.remove(new Pair(i, j));
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Pair, Integer> pairIntegerEntry : map.entrySet()) {
            if (3 == pairIntegerEntry.getValue()) {
                Pair key = pairIntegerEntry.getKey();
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(key.a);
                integers.add(key.b);
                result.add(integers);
            }
        }
        return result;
    }

    private int getFlag(int[][] heights, Map<Pair, Integer> map, int i, int j, Set<Pair> set) {
        int flag = 0;
        //up
        if (i != 0 && heights[i - 1][j] <= heights[i][j] && !set.contains(new Pair(i - 1, j))) {
            Pair key = new Pair(i - 1, j);
            Integer val = map.get(key);
            if (val == null) {
                set.add(key);
                map.put(key, getFlag(heights, map, i - 1, j, set) );
                flag = flag | map.get(key);
                set.remove(key);
            } else {
                flag = flag | val;
            }
        }
        //down
        if (i != heights.length - 1 && heights[i + 1][j] <= heights[i][j] && !set.contains(new Pair(i + 1, j))) {
            Pair key = new Pair(i + 1, j);
            Integer val = map.get(key);
            if (val == null) {
                set.add(key);
                map.put(key, getFlag(heights, map, i + 1, j, set) );
                flag = flag | map.get(key);
                set.remove(key);
            } else {
                flag = flag | val;
            }
        }
        //left
        if (j != 0 && heights[i][j - 1] <= heights[i][j] && !set.contains(new Pair(i, j - 1))) {
            Pair key = new Pair(i, j - 1);
            Integer val = map.get(key);
            if (val == null) {
                set.add(key);
                map.put(key, getFlag(heights, map, i, j - 1, set) );
                flag = flag | map.get(key);
                set.remove(key);
            } else {
                flag = flag | val;
            }
        }
        //right
        if (j != heights[0].length - 1 && heights[i][j + 1] <= heights[i][j] && !set.contains(new Pair(i, j + 1))) {
            Pair key = new Pair(i, j + 1);
            Integer val = map.get(key);
            if (val == null) {
                set.add(key);
                map.put(key, getFlag(heights, map, i, j + 1, set) );
                flag = flag | map.get(key);
                set.remove(key);
            } else {
                flag = flag | val;
            }
        }

        //meet ocean
        if (i == 0) {
            flag = flag | 1;
        }
        if (i == heights.length - 1) {
            flag = flag | 2;
        }
        if (j == 0) {
            flag = flag | 1;
        }
        if (j == heights[0].length - 1) {
            flag = flag | 2;
        }


        return flag;
    }

    class Pair {
        public int a;
        public int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }


    public static void main(String[] args) {
        int[][] input1 = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        //System.out.println(new Solution().pacificAtlantic(input1).toString());

        int[][] input2 = {{10, 10, 10}, {10, 1, 10}, {10, 10, 10}};
        System.out.println(new Solution().pacificAtlantic(input2).toString());


    }
}
