package com.aiqiyi;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-08-22-4:18 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] nums = sc.nextLine().split(",");
            int n = nums.length;
            int[] num = new int[n];
            int min = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                num[i]=Integer.parseInt(nums[i]);
            }
            list.add(num[0]);
            for (int i = 1; i < n; i++) {
                while(i<n && num[i]>=num[i-1]) i++;
                if(i==n){
                    list.add(num[i-1]);
                    break;
                }
                list.add(num[i-1]);
                while(i<n && num[i]<=num[i-1]) i++;
                if(i==n){
                    list.add(num[i-1]);
                    break;
                }
                list.add(num[i]);
                i--;

            }
            int res = 0;
            for (int i = 1; i < list.size(); i++) {
                if(Math.abs(list.get(i)-list.get(i-1))>res){
                    res=Math.abs(list.get(i)-list.get(i-1));
                }
            }
            System.out.println(res);
        }
    }
}
