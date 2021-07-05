package forJob.shopee;

/**
 * @author skyliuhc
 * @create 2021-07-05-5:14 下午
 */
public class Solution3_right {
    int[][] rooms;
    boolean[][] visited;
    int[] start;
    int[] end;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int global_max = Integer.MAX_VALUE;
    public int minimumInitHealth(int[][] _rooms,int[] _start,int [] _end){
        start = _start;//出发点
        end = _end;//结束点
        rooms =_rooms;
        int n = _rooms.length;
        visited = new boolean[n][n];//是否访问数组
        back_track(start[0],start[1],0,0);
        return global_max+1;//生命值至少为1
    }

    private void back_track(int x, int y, int health, int local_max) {
        if(x<0 || x>= rooms.length||y<0||y>= rooms.length||visited[x][y]||local_max>global_max){
            //前四项 是边界条件，visited[x][y]是只能走一次 ，
            // local_max>global_max剪枝，
            // 表示比当前得到的最好解要差就不搜索了
            return;
        }
        health=health-rooms[x][y];
        local_max=Math.max(local_max,health);
        //local_max初始值为0，会忽略掉过程Health等于负数的时候
        if(x==end[0] &&y ==end[1]){
            global_max=Math.min(global_max,local_max);//取最小的Health;
            return;
        }
        visited[x][y]=true;//标记访问
        for (int[] dir : dirs) {
            int next_x = x+dir[0];
            int next_y = y+dir[1];
            back_track(next_x,next_y,health,local_max);
        }
        visited[x][y]=false;//恢复状态
    }
}
