package com.redbook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-04-10:42 上午
 */
public class Solution {
    String s;
    int n;
    boolean[][] dp;
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public int partitionNumber(String text) {
        this.s = text;
        this.n = text.length();
        this.dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int l=n-1;l>-1;l--){
            for(int r =l+1;r<n;r++){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l==1){
                        dp[l][r]=true;
                    }else{
                        if(dp[l+1][r-1]==true){
                            dp[l][r]=true;
                        }
                    }
                }
            }
        }
        backtrace(0);
        int rn = res.size();
        return rn;

    }
    void backtrace(int idx){
        if(idx==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<n;i++){
            if(dp[idx][i]==true){
                path.add(s.substring(idx,i+1));
                backtrace(i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
