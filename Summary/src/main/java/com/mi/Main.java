package com.mi;
//m=2,n=2
//1,3
//2,4
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int m = Integer.parseInt(split[0].substring(2));
        int n = Integer.parseInt(split[1].substring(2));
        int[] nums1 = new int[m];
        str = sc.nextLine();
        String[] strnums1 = str.split(",");
        for(int i=0;i<m;i++){
            nums1[i] = Integer.parseInt(strnums1[i]);
        }
        int[] nums2 = new int[n];
        str = sc.nextLine();
        String[] strnums2 = str.split(",");
        for (int i = 0; i < n; i++) {
            nums2[i]=Integer.parseInt(strnums2[i]);
        }
        int[] res = new int[m+n];
        for (int i = 0; i < m; i++) {
            res[i]=nums1[i];
        }
        merge(res,m,nums2,n);
        for (int num : res) {
            System.out.print(num+" ");
        }

    }
    static void merge(int[] nums1,int m,int[] nums2,int n){
        for (int i = 0; i !=n ; i++) {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }

}