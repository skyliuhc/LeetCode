package WeekTest;

public class LeetCode5762 {
    // 第一类 斯特林数
    int N = 1010;
    int MOD = 1000000007;
    int[][] f = new int[N][N];
    public int rearrangeSticks(int n, int k) {
        f[0][0] = 1;
        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= k; j ++ )
                f[i][j] = (int)((f[i - 1][j - 1] + (long)(i - 1) * (f[i - 1][j])) % MOD);
        return f[n][k];
    }


}
