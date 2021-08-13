package com.offer2.array;

import java.util.HashMap;

/**
 * @author skyliuhc
 * @create 2021-08-12-10:35 上午
 */
public class offer11_findMaxLength {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int res =0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum=nums[i]==0?sum-1:sum+1;
            if(map.containsKey(sum)){
                res = Math.max(res,i-map.get(sum));
            }else{
                map.put(sum,i);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int sum =0;
        boolean flag = false;
         sum = flag ? sum++ : sum--;
//        System.out.println(i);
        System.out.println(sum);
    }
}
