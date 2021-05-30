package Labuladong.src.WeekTest;

import java.util.Arrays;

public class LeetCode5755 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min =0;
        for(int i =0;i<nums.length/2;i++){
            min = Math.max(min,nums[i]+nums[nums.length-i-1]);
        }
        return min;
    }
}
