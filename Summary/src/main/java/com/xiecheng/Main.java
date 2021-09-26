package com.xiecheng;

/**
 * @author skyliuhc
 * @create 2021-09-09-8:23 下午
 */
public class Main extends Thread{
    public static void main(String[] args) {
//        int[] nums = {3,5,5,2,5};
//        int k=4;
        int[] nums = {3,4,7,6};
        int k = 2;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min,nums[i]);
            max= Math.max(max,nums[i]);
        }
        int r = max- min;
        int l = 0;
        int ans = max-min;
        while (l<=r){
            int mid = (r-l)/2+l;
            if(check(nums,mid,k)){
                r=mid-1;
                ans = Math.min(ans,mid);
            }else{
                l=mid+1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int[] nums, int mid,int k) {
        //得到这个最大不平衡  的情况下用到的最小段数
        int min = 0;
        int max = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0,j=0; i < n; count++) {
            if (count==k){
                return  false;
            }
            min = nums[i];
            max = nums[i];
            j=i;
            while (++j<n){
                min=Math.min(nums[j],min);
                max=Math.max(nums[j],max);
                if (max-min>mid){
                    break;
                }
            }
            i=j;
        }
        return true;
    }

}
