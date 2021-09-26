package com.redbook;

import java.io.*;
import java.util.Arrays;

/**
 * @author skyliuhc
 * @create 2021-09-04-11:16 上午
 */
public class Main3 {
//             k=4
//            1->2. 3
//            1->3  1
//            1->4  2
//            3->5  1
//
//            1和2,3,4,5
//            2和3
//            3和4，5
//            4和5
    static int N = 10010;
    static int max = 0x3f3f3f;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m;//一个是节点数 ，一个是边数
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
         n = Integer.parseInt(NK[0]);//树的节点数
         m=n-1;
        int k = Integer.parseInt(NK[1]);//最大时间
        int[] a = new int[n-1];
        int[] b = new int[n-1];
        int[] c = new int[n-1];
        String[] abc = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            a[i]=Integer.parseInt(abc[i*3+0]);
            b[i]=Integer.parseInt(abc[i*3+1]);
            c[i]=Integer.parseInt(abc[i*3+2]);
            g[a[i]][b[i]] = c[i];
            g[b[i]][a[i]] = c[i];

        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(dijstra(i,j)<=k){
                    res++;
                }
            }
        }
        System.out.println(res);
        br.close();
    }
    static int dijstra(int start,int end){
        Arrays.fill(dist,max);
        dist[start] = 0;
        for(int i=0;i<n-1;i++){
            int t=-1;
            for(int j=start;j<=n;j++){
                if(st[j])continue;
                if(t==-1||dist[j]<dist[t]){
                    t=j;
                }

            }
            st[t]=true;
            for (int j = start; j < n; j++) {
                if(dist[j]>dist[t]+g[t][j]){
                    dist[j]=dist[t]+g[t][j];
                }
            }
        }
        if(dist[end]==max){
            return max;
        }else{
            return dist[end];
        }
    }

}
