package com.携程.第二题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-30-7:50 下午
 */

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);

        int start = nums[0];
        start++;
        int anger = 0;
        for(int i=1;i<n;i++){
            while(start<nums[i]){
                start++;
            }
            anger+=Math.abs(start-nums[i]);
            start++;
        }
        System.out.println(anger);
    }
}