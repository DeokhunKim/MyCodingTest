package leetcode.c6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        List<Character>[] zigzag = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new ArrayList<>();
        }
        int increaseVal = numRows == 1 ? 0 : 1;
        int increasePN = 1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            zigzag[row].add(s.charAt(i));

            if (row == 0) {
                increasePN = 1;
            } else if (row == numRows - 1) {
                increasePN = -1;
            }
            row = row + increaseVal * increasePN;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (Character character : zigzag[i]) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        String convert = new Solution().convert(s, numRows);
        System.out.println("convert = " + convert);
    }
}
