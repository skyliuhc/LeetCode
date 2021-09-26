package com.honor.my;

/**
 * @author skyliuhc
 * @create 2021-09-14-6:10 下午
 */
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String guest = split[0];
        int target = 0;
        int[] nums = new int[split.length-1];
        for(int i=0;i<guest.length();i++){
            char temp =Character.toLowerCase(guest.charAt(i));
            target+= temp-'a'+1;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = 0;
            String value  = split[i+1];
            for(int j=0;j<value.length();j++){
                char temp =Character.toLowerCase(value.charAt(j));
                nums[i]+= temp-'a'+1;
            }
        }

//        int min = Integer.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < nums.length; i++) {
//            int curr = Math.abs(target-nums[i]);
//            if(curr<min){
//                index = i;
//                min = curr;
//            }
//        }
//        int ans = index+1;
        int ans1 = search1(nums,target);
//        int ans2 = search2(nums,target);
        System.out.println(ans1);
//        System.out.println(ans2);;
        int res1 = Math.abs(nums[ans1]-target);
//        int res2 =Math.abs(nums[ans2]-target);
//        if(res1<res2){
//            System.out.println(split[ans1]);
//        }else{
//            System.out.println(split[ans2]);
//        }

    }

    static int search1(int[] nums,int target){
        int l =0,r=nums.length-1;
        while(l<r){
            int mid =(l+r)/2;
            if(nums[mid]<target) l=mid+1;
            else  r=mid;
        }
        return l;
    }
    static int search2(int[] nums,int target){
        int l =0,r=nums.length-1;
        while(l<r){
            int mid =(l+r+1)/2;
            if(nums[mid]>target) l=mid;
            else  r=mid-1;
        }
        return l;
    }

}