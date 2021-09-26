package com.aiqiyi;

/**
 * @author skyliuhc
 * @create 2021-08-22-4:32 下午
 */


import java.util.*;

public class Main {

    static char[][] g ;
    static boolean[] col;
    static boolean[] dg;
    static boolean[] udg ;
    static int n;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sss = sc.next();
        System.out.println(sss);
        String strn = sss.substring(2,sss.length());
        System.out.println(strn);
        n = Integer.parseInt(strn);
        col = new boolean[n];
        dg = new boolean[2*n];
        udg = new boolean[2*n];
        g = new char[n][n];
        for(int i=0;i<n;i++){
          Arrays.fill(g[i],'.');
        }

        System.out.print("[");
        dfs(0);
        int len = sb.toString().length();
        System.out.print(sb.toString().substring(0,len-2));
        System.out.print("]");
    }

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                if(i==0){
                    sb.append("[");
                }
                sb.append(new String(g[i]));
                if(i!=n-1){
                    sb.append(",");
                }else{
                    sb.append("]");
                }
            }
            sb.append(", ");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i - u + n] && !udg[i + u]) {
                g[u][i] = 'Q';
                col[i] = dg[i - u + n] = udg[i + u] = true;
                dfs(u + 1);
                col[i] = dg[i - u + n] = udg[i + u] = false;
                g[u][i] = '.';
            }
        }
    }


}