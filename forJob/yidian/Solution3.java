package forJob.yidian;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-08-07-10:55 下午
 */
public class Solution3 {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int waste =0;
        int n = nums.length;
        if(k==0){
            int max = Arrays.stream(nums).max().getAsInt();
            for (int i = 0; i < n; i++) {
                waste+=max-nums[i];
            }
        }else{


        }
        return waste;
    }

    
    public static void main(String[] args) {
//        int[] t = {1,4,5,6};
//        int max = Arrays.stream(t).max().getAsInt();
//        System.out.println(max);
        Solution3 s3 = new Solution3();
        int[] nums = {10,20,15,30,20};
        int k = 2;
        System.out.println(s3.minSpaceWastedKResizing(nums, k));
    }
}
