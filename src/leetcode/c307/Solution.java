package leetcode.c307;

public class Solution {

    public static void main(String[] args) {

        //["NumArray","sumRange","sumRange","sumRange",
        //[0,9,5,7,3]],[4,4],[2,4],[3,3]
        // "update","update","update","sumRange",
        //[4,5],[1,7],[0,8],[1,2]
        // "update","sumRange","update"]
        //[,[1,9],[4,4],[3,4]]

        //          24
        //     14          10
        //   9     5    7     3
        //0    9

        //          24+2-2+8
        //     14-2+8      10+2
        //   9+8    5    7     3+2
        //0+8   9

        int[] inp = {0,9,5,7,3};
        NumArray numArray = new NumArray(inp);
        System.out.println("numArray = " + numArray.sumRange(4,4));
        System.out.println("numArray = " + numArray.sumRange(2,4));
        System.out.println("numArray = " + numArray.sumRange(3,3));
        numArray.update(4, 5);
        numArray.update(1, 7);
        numArray.update(0, 8);
        System.out.println("numArray.sumRange(1,2) = " + numArray.sumRange(1, 2));
        numArray.update(1, 9);
        System.out.println("numArray.sumRange(4,4) = " + numArray.sumRange(4, 4));


    }
}
