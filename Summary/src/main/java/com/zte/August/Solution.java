package com.zte.August;


import java.util.*;

public class Solution {
    //只过了15%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String substring = input.substring(1, input.length() - 1);
        String[] split = substring.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (entry.getValue()>res){
                res = entry.getValue();
            }
        }
        System.out.println(res);
    }
}
