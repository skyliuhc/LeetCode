package com.jd.爱gougou;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-10-09-8:34 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数量
        int k = sc.nextInt();//预算，成本
        int d = sc.nextInt();//系数d
        int[] a = new int[n];//喜爱值
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            p[i][0] = a[i];
            p[i][1] = i;
        }
        Arrays.sort(p,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int [] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            degrees[p[i][1]] = i+1;
        }

        List<Integer> list1 = new ArrayList<>();
        int[] b = new int[n];//领养成本
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            if(b[i]<=k){
                list1.add(i);
            }
        }
        List<Integer> list2 = new ArrayList<>();
        int[] feed = new int[n];
        for (int i = 0; i < feed.length; i++) {
            feed[i] = d/n*degrees[i];
        }
        int[] c = new int[n];//喂养成本
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
            if(feed[i]>=c[i]){
                list2.add(i);
            }
        }
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(list1.contains(i) && list2.contains(i)){
                s.add(i);
            }
        }
        int index = -1;
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            int j = s.get(i);
            if(degrees[j]>max){
                max = degrees[j];
                index = j+1;
            }
        }
        System.out.println(index);
    }
}
