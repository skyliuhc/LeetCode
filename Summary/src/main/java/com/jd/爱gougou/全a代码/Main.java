package com.jd.爱gougou.全a代码;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-10-09-10:47 下午
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str=br.readLine())!=null){
            String[] strArr = str.split(" ");
            int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
            int n = intArr[0];
            int k = intArr[1];
            int d = intArr[2];

            int[] love = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] getFee = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] feedFee = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(love[i]);
                tmp.add(getFee[i]);
                tmp.add(feedFee[i]);
                list.add(tmp);
            }
            list.sort((a,b)->a.get(0)-b.get(0));
            int mostLove = 0;
            for (int i = 0; i < list.size(); i++) {
                int feedBudget = (d/n)*(i+1);
                int get = list.get(i).get(1);
                int feed = list.get(i).get(2);
                if(get<=k && feed<=feedBudget){
                    mostLove = Math.max(mostLove,list.get(i).get(0));// 求的是喜爱度，不是序号
                }
            }
            System.out.println(mostLove==0?-1:mostLove);
        }
        br.close();
    }
}
