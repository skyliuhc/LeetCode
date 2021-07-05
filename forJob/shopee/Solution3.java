package forJob.shopee;

/**
 * @author skyliuhc
 * @create 2021-07-05-3:55 下午
 */
public class Solution3 {
    static int[] dx={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int ans ;
    static int N;
    static  int endx;
    static int endy;
    boolean[][] vis;
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {

        int n = rooms.length;
        N=n-1;
        int x = startPoint[0];
        int y = startPoint[1];
        endx= endPoint[0];
        endy = endPoint[1];
        ans  = rooms[x][y];
        if(x==endx&&endy==y){
            if(ans>0){
                return 1;
            }else{
                return 0-ans;
            }

        }
        vis = new boolean[n][n];
        vis[x][y] = true;

        dfs(x,y,ans,rooms);

        return 0-ans;

    }
    void dfs(int x,int y,int temp,int[][] rooms){
        if(x==endx && y==endy){

            return;
        }
        for (int i = 0; i < 4; i++) {
            int tx= dx[i]+x;
            int ty = dy[i]+y;
            if(tx<0||tx>endx||ty<0||ty>endy||vis[tx][ty]){
                continue;
            }
            vis[tx][ty] = true;
            temp+=rooms[tx][ty];
            ans=Math.min(ans,temp);
            dfs(tx,ty,temp,rooms);
        }
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] start = new int[]{0,0};
        int[] end = new int[]{2,2};
        Solution3 s = new Solution3();
        System.out.println(s.minimumInitHealth(rooms, start, end));
    }

}
