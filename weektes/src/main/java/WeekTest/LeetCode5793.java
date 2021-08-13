package WeekTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class LeetCode5793{
    int[] dx ={-1,1,0,0},dy={0,0,-1,1};
    public int nearestExit(char[][] g, int[] entrance) {
        int n = g.length;
        int m = g[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        int start =entrance[0];
        int end =entrance[1];
        dist[start][end] = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start,end});
        while(!queue.isEmpty()){
            int a[] = queue.poll();
            for(int i=0;i<4;i++){
                int x = a[0] + dx[i];
                int y = a[1] + dy[i];
                if(x>=0 && x<n &&y>=0 && y<m  && g[x][y] =='.'
                        && dist[x][y]>dist[a[0]][a[1]]+1){
                    dist[x][y] =dist[a[0]][a[1]]+1;
                    if ((x == 0 ||x==n-1|| y == 0 || y==m-1 )) return dist[x][y];
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return -1;
    }
}
