package com.huawei.my;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-08-25-7:37 下午
 */
public class Main2 {

    static int[][] g;
    static int[][] d;
    static int[] dx ={-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        g = new int[row][col];
        d = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                g[i][j]= sc.nextInt();
            }
        }
        System.out.println("-1");
    }
    static int bfs(int n,int m){
        Queue<int[]> queue = new LinkedList<>();
        d[0][0] = g[0][0];//剩余的时间
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){

            int[] a = queue.poll();
            for(int i=0;i<4;i++){
                int x = a[0]+dx[i];
                int y = a[1]+dy[i];
                if(x>=0 &&x<n && y<m && g[x][y] >0 ){
                    g[x][y] --;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return g[n-1][m-1];
    }
}
