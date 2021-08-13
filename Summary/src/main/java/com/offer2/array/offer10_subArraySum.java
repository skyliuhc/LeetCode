package com.offer2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skyliuhc
 * @create 2021-08-12-10:03 上午
 */
public class offer10_subArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//如果nums[i]=k，那么至少有一种方案
        int res = 0;
        int pre = 0;
        for(int num:nums){
            pre += num;
            int x = pre - k;
            res += map.getOrDefault(x,0);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }
}
