package Hot128;
import java.util.*;
public class Solution {
    //比较直观的想法，可以过
    //最长连续序列
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int count =1;
        int res =0;
        for(int i=1;i<len;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]-nums[i-1]==1){
                count++;
            }else{
                res=Math.max(count,res);
                count=1;
            }
        }
        return Math.max(res,count);
    }
}
