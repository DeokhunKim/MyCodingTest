package leetcode.c393;

public class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int checkNextByte = 0;
            if (data[i] < 0b10000000) {
                //checkNextByte = 0;
                //nothing..
            } else if (data[i] < 0b11000000) {
                return false;
            } else if (data[i] < 0b11100000) {
                checkNextByte = 1;
            } else if (data[i] < 0b11110000) {
                checkNextByte = 2;
            } else if (data[i] < 0b11111000) {
                checkNextByte = 3;
            } else {
                return false;
            }

            if (data.length - i - 1 < checkNextByte) {
                return false;
            }

            for (int j = 0; j < checkNextByte; j++) {
                i++;
                if (0b01111111 < data[i] && data[i] < 0b11000000) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().validUtf8(new int[]{197, 130, 1}));
       // System.out.println(new Solution().validUtf8(new int[]{235, 140, 4}));
        System.out.println(new Solution().validUtf8(new int[]{237}));

    }
}
