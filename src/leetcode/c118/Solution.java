package leetcode.c118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> lineList = new ArrayList<>();
            lineList.add(1);
            List<Integer> prevList = result.get(result.size() - 1);
            for (int j = 1; j < prevList.size(); j++) {
                lineList.add(prevList.get(j-1) + prevList.get(j));
            }
            lineList.add(1);
            result.add(lineList);
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Integer>> generate = new Solution().generate(5);
        System.out.println("generate = " + generate);

    }
}
