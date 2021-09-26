package com.honor.my;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-09-14-6:48 下午
 */
public class Main3 {
    //16|16|16
    //1|0|2|320
    //2|0|2|160
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] groups = null;//每个小组
        groups = process(s);

        int T = groups.length;
        int[] speed = new int[T];
        int k=0;
        while (T-- > 0) {
            String temp = sc.nextLine();
            speed[k++]=getSpeed(temp);
        }
        for (int i = 0; i < groups.length; i++) {
            int times = speed[i]/groups[i];
            System.out.println(groups[i]+1+"|"+"");
        }
    }

    static int[] process(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                sb.append(',');
            } else {
                sb.append(s.charAt(i));
            }
        }
        String cnm = sb.toString();
        String[] cnms = cnm.split(",");

        int[] groups = new int[cnms.length];//每个小组
        for (int i = 0; i < groups.length; i++) {
            groups[i] = Integer.parseInt(cnms[i]);
        }
        return groups;
    }

    static int getSpeed(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                sb.append(',');
            } else {
                sb.append(s.charAt(i));
            }
        }
        String cnm = sb.toString();
        String[] cnms = cnm.split(",");
        int n = cnms.length;
        int speed = Integer.parseInt(cnms[n - 1]) * Integer.parseInt(cnms[n - 2]);
        return speed;
    }


}
