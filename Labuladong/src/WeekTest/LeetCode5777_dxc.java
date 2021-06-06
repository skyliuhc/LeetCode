package Labuladong.src.WeekTest;

import java.util.Arrays;

public class LeetCode5777_dxc {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res =0;
        for(int i=1,s=0;i<nums.length;i++){
            if(nums[i]!=nums[i-1]) s++;
            res+=s;
        }
        return res;
    }
}
