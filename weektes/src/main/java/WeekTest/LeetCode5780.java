package WeekTest;

import java.util.Arrays;

public class LeetCode5780 {
    int[] q;
    public boolean canBeIncreasing(int[] nums) {
        if(check(nums)){
            return true;
        }else{
            q=new int[nums.length-1];
            for (int i = 0; i < nums.length; i++) {
                Arrays.fill(q,0);
                for (int j = 0,k=0; j < nums.length; j++) {
                    if(j!=i){
                        q[k++]=nums[j];
                    }
                }
                if(check(q)){
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean check(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
