package com.offer2.Integer;

/**
 * @author skyliuhc
 * @create 2021-08-11-9:50 上午
 */
public class offer9_numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length;
        int res = 0;
        int l = 0, r = 0;
        int windows = 1;
        while (r < n) {
            windows *= nums[r];
            while (windows >= k) {//需要缩小窗口的时候
                windows /= nums[l++];
            }
            res += r - l + 1;//以r结尾的子数组都是合法的 比如窗口[5,2,6] 那么[5,2,6] [2,6] [6]都是合法的
            r++;
        }
        return res;
    }


}
