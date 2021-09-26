package com.acwing;
import java.util.*;
/**
 * @author skyliuhc
 * @create 2021-09-17-10:54 上午
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-2};
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first>0 && nums[first]==nums[first-1]){
                continue;//去重
            }
            int third = n-1;
            target = -nums[first];//a+b+c = 0 b+c=-a
            for (int second = first+1; second < n; second++) {
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;//去重
                }
                while (second<third && nums[second]+nums[third]>target){
                    third--;//左移
                }
                if (second==third){
                    break;
                }
                if (nums[second]+nums[third]==target){
                    //满足就在结果集上
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
