package com.拼多多.第一题;

/**
 * @author skyliuhc
 * @create 2021-10-11-7:07 下午
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int h= sc.nextInt();
            int w=sc.nextInt();
            char[][] pic = new char[h][w];
            for(int i=0;i<h;i++){
                String s = sc.next();
                for(int j=0;j<w;j++){
                    pic[i][j]=s.charAt(j);
                }
            }
            if(check(pic)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean check(char[][] c){
        int n = c.length;
        int m = c[0].length;
        boolean[][] flag = new boolean[n][m];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(c[i][j]=='*'){
                    flag[i][j] = true;
                    rows[i]=true;
                    cols[j]=true;
                    cnt++;
                }
            }
        }
        if(cnt%2==0){
            return false;
        }else{
            int col = 0;
            int row = 0;
            int s1 = Integer.MAX_VALUE;//行开始
            int e1 = Integer.MIN_VALUE;//行结束
            for (int i = 0; i < n; i++) {
                if(rows[i]){
                    s1=Math.min(i,s1);
                    row++;
                    e1=Math.max(i,e1);
                }
            }
            int s2 = Integer.MAX_VALUE;
            int e2 = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if(cols[i]){
                    s2=Math.min(i,s2);
                    col++;
                    e2=Math.max(i,e2);
                }
            }
            if(row!=col ){
                return false;
            }
            if((e1-s1+1)%2==0 || (e2-s2+1)%2==0 || (e1-s1)!=(e2-s2)){
                return false;
            }
            int len = (s2-e2)/2;
            int mid1 = (s1+e1)/2;
            int mid2 = (e2+s2)/2;
            for (int i = 0; i < len; i++) {
                if(mid1-i<0 || mid2-i<0 || mid1+i>=n || mid2+i>=m ){
                    return false;
                }else{
                    if(!flag[mid1-i][mid2] || !flag[mid1][mid2-i] || !flag[mid1][mid2-i] || !flag[mid1+i][mid2]){
                        return false;
                    }
                }
            }
            return  true;
        }

    }
}