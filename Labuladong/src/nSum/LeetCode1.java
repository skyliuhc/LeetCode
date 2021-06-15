package Labuladong.src.nSum;

import java.util.HashMap;

public class LeetCode1 {
    //两数之和 转换成target-当前数在不在map中
    public  int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
