package com.weekTest;

import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-08-15-3:06 下午
 */
public class LeetCode5832 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length;
        int r = n-1;
        int l = 0;
        int[] res = new int[n];
        for (int i = 0; i <n ; i++) {
            if (i%2==1){
                res[i]=nums[r];
                r--;
            }else{
                res[i]=nums[l];
                l++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LeetCode5832 o1 = new LeetCode5832();
        int[] t ={1,2,3,4,5};
        int[] ints = o1.rearrangeArray(t);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
