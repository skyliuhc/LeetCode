package forJob;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int C = sc.nextInt();
        String t1 = sc.next();

        String[] weight = t1.split(",");
        String t2 = sc.next();

        String[] value = t2.split(",");
        int[] w = new int[weight.length+1];
        for (int i = 1; i <w.length; i++) {
            w[i]=Integer.parseInt(weight[i-1]);
        }

        int[] v = new int[value.length+1];
        for (int i = 1; i <v.length; i++) {
            v[i]=Integer.parseInt(value[i-1]);
        }
        int n = v.length;
        System.out.println(getValue(C,n-1,v,w));
    }

    public static int getValue(int C, int n,int[]  v,int[] w){
        int[][] dp = new int[n+1][C+1];
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=C; j++) {
                if(j>=w[i]){
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][C];
    }
}
