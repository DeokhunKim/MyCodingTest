package leetcode.c315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] sumResult = new int[nums.length];
        Arrays.fill(sumResult, 0);

        int[][] input = new int[nums.length][3];
        for (int i = 0; i < input.length; i++) {
            input[i][0] = nums[i];
            input[i][1] = i;
            input[i][2] = 0;
        }

        int[][] rev = rev(Arrays.copyOfRange(input, 0, input.length / 2),
                Arrays.copyOfRange(input, input.length / 2, input.length));
        Arrays.sort(rev, Comparator.comparingInt((int[] t) -> t[1]));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rev.length; i++) {
            result.add(rev[i][2]);
        }

        return result;
    }


    // int[][0] = value
    // int[][1] = original index
    // int[][2] = sum of less to right
    public int[][] rev(int[][] left, int[][] right) {
        int[][] sortedLeft;
        int[][] sortedRight;

        // 나누고
        if (left.length > 1) {
            sortedLeft = rev(Arrays.copyOfRange(left, 0,left.length/2), 
                    Arrays.copyOfRange(left, left.length/2, left.length ));
        } else {
            sortedLeft = left;
        }

        if (right.length > 1) {
            sortedRight = rev(Arrays.copyOfRange(right, 0,right.length/2), 
                    Arrays.copyOfRange(right, right.length/2, right.length ));
        } else {
            sortedRight = right;
        }

        // 합 구하고
        int rightStart = 0;
        int stackSumNum = 0;
        for (int i = 0; i < sortedLeft.length; i++) {
            for (int j = rightStart; j < sortedRight.length; j++) {
                if (sortedLeft[i][0] > sortedRight[j][0]) {
                    stackSumNum++;
                    rightStart++;
                } else {
                    break;
                }
            }
            sortedLeft[i][2] += stackSumNum;
        }
        // 합친다음 정렬해서 반환
        //int[][] mergeArray = Stream.of(sortedLeft, sortedRight).flatMap(Stream::of).toArray(int[][]::new);
        //Arrays.sort(mergeArray, Comparator.comparingInt((int[] t) -> t[0]));
        //위 코드가 시간이 오래 걸려서 변경
        int[][] mergeArray = new int[sortedLeft.length+ sortedRight.length][3];
        int indexL = 0, indexR = 0;
        for (int i = 0; i < sortedLeft.length + sortedRight.length; i++) {
            if (indexL == sortedLeft.length) {
                mergeArray[i] = sortedRight[indexR++];
            } else if (indexR == sortedRight.length) {
                mergeArray[i] = sortedLeft[indexL++];
            } else if (sortedLeft[indexL][0] > sortedRight[indexR][0]) {
                mergeArray[i] = sortedRight[indexR++];
            } else {
                mergeArray[i] = sortedLeft[indexL++];
            }
        }

        return mergeArray;
    }

    public static void main(String[] args) {

        int[] t = {0,0,0,0,0,0,0,2,2,3};
        int i = Arrays.binarySearch(t, 0);
        int i2 = Arrays.binarySearch(t, 1);
        int i3 = Arrays.binarySearch(t, 2);


        int[] inp = {7,6,5,4,3,2,1};
        List<Integer> integers = new Solution().countSmaller(inp);
        System.out.println("integers = " + integers.toString());


    }
}
