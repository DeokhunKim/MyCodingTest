package leetcode.c858;

public class Solution {

    public int mirrorReflection(int p, int q) {
        int result = 0;
        int small = q; // 2
        int big = p; // 3
        boolean reverse = false;
        if (p < q) {
            small = p;
            big = q;
            reverse = true;
        }
        //2  1
        //-1  0
        int val = small;
        int c = 0;
        while (true) {
            if (val % big == 0) {
                if (((double) val / (double) big )% 2 == 0) { // 작수
                    if (c % 2 == 0) {
                        result = 0;
                    if(reverse)
                        result = 2;
                    } else {
                        result = -1;
                    }
                } else { // 혹수 = 정상
                    if (c % 2 == 0) {
                        result = 1;
                    } else {
                        result = 2;
                        if(reverse)
                            result = 0;
                    }
                }
                break;
            }
            c++;
            val += small;
        }


        return result;
    }

    public static void main(String[] args) {
        //2  1
        //-1  0
       int i = new Solution().mirrorReflection(3, 1);
       int i2 = new Solution().mirrorReflection(2, 1);
       int i3 = new Solution().mirrorReflection(4, 3);
       int i4 = new Solution().mirrorReflection(3, 2);
       int i5 = new Solution().mirrorReflection(3, 4);
       //System.out.println("i = " + i);
       //System.out.println("i2 = " + i2);
       //System.out.println("i3 = " + i3);
       //System.out.println("i4 = " + i4);

        System.out.println("Solution.main");


    }


}
