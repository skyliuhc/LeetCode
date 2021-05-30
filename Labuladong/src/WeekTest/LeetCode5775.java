package Labuladong.src.WeekTest;

public class LeetCode5775 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        long[][] dp = new long[n + 1][n + 1];
        //dp[i][j] 表示经过了 i段路，并且逃过了j次的最短用时
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= n; j++) {
                //由于浮点数有精度限制，直接除的话会导致精度丢失，所以先把分子存下来，最后统一做除法
                //就是说再除以speed
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][j] + dist[i - 1] + speed - 1) / speed * speed;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + dist[i - 1], (dp[i - 1][j] + dist[i - 1] + speed - 1) / speed * speed);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if ((double) (dp[n - 1][i] + dist[n - 1]) / (double) speed <= (double) hoursBefore)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1/2*2);
    }
}
