package leetcode.c377;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] array = new int[201];
        Arrays.sort(nums);
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);

        for (int smallTarget = 1; smallTarget <= target; smallTarget++) {
            int sumdp = sumdp(nums, smallTarget, 0, dp);
            if (smallTarget == target) {
                return sumdp;
            }
            //System.out.println("sumdp = " + sumdp);
        }



        return dp[target];
    }

    public int sumdp(int[] nums, int smallTarget, int sum, int[] dp) {
        int findNum = smallTarget - sum;
        if(dp[findNum] != -1){
            return dp[findNum];
        }

        int collect = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < smallTarget) {
                collect += sumdp(nums, smallTarget, sum + nums[i], dp);
            } else if (sum + nums[i] == smallTarget) {
                dp[smallTarget] = collect + 1;
                collect = dp[smallTarget];
                break;
            } else if (sum + nums[i] > smallTarget) {
                break;
            }
        }
        dp[smallTarget] = collect;
        return collect;
    }





    public static void main(String[] args) {
        //int nums[] = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int nums[] = {1,2,3};
        int target = 35;


        int i = new Solution().combinationSum4(nums, target);
        System.out.println("i = " + i);

    }


}
