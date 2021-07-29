package Labuladong.src.WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-18-11:12 上午
 */
public class LeetCode5815 {
    int ans = Integer.MIN_VALUE;


    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] f = new long[n][m];
        for (int i = 0; i < m; i++) {
            f[0][i] = points[0][i];
        }
        for (int i = 1; i < n; i++) {
//            ret 算的是f[i-1][k]-k or f[i-1][k]+k的最大值
            long ret = f[i - 1][0];//k<j
            for (int j = 0; j < m; j++) {
                ret = Math.max(f[i - 1][j] + j, ret);
                f[i][j] = Math.max(f[i][j], points[i][j] + ret - j);
            }
            ret = f[i - 1][n - 1] - (n - 1);//k>j
            for (int j = n - 2; j >= 0; j--) {
                f[i][j] = Math.max(f[i][j], points[i][j] + ret + j);
                ret = Math.max(ret, f[i - 1][j] - j);
            }
        }
        long res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(f[n - 1][i], res);
        }
        return res;
    }
}
