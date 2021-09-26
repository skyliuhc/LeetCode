package com.每日一题.Shopee;

/**
 * @author skyliuhc
 * @create 2021-09-22-4:08 下午
 */
public class Solution {
    public String didYouMean(String[] commands, String input) {
        // write code here
        int min = Integer.MAX_VALUE;
        int index = -1;
        int n = commands.length;
        for(int i=0;i<n;i++){
            String temp = commands[i];
            int dist = getD(temp,input);
            if(dist<min){
                min = dist;
                index = i;
            }

        }
        return commands[index];
    }
    public int getD(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        String t1 = " "+s1;
        String t2 = " "+s2;
        int[][] f = new int[n+1][m+1];
        for(int i=0;i<=m;i++) f[0][i]=i;
        for(int i=0;i<=n;i++) f[i][0]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j] = Math.min(f[i-1][j]+1,f[i][j-1]+1);
                if(t1.charAt(i)==t2.charAt(j)) f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                else f[i][j]=Math.min(f[i][j],f[i-1][j-1]+1);
            }
        }
        return f[n][m];
    }


}
