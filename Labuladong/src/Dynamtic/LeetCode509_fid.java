package Labuladong.src.Dynamtic;

/**
 * @author skyliuhc
 * @create 2021-07-03-9:42 上午
 */
public class LeetCode509_fid {
    //    斐波那契数
    //第一递归写法
    //只打过20% ,20%
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib_memo(int n) {
        if (n < 1) return 0;
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    //动态规划求解
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0, curr = 0, sum = 1;
        for (int i = 2; i <= n; i++) {
            prev = curr;//f[n-2]
            curr = sum;//f[n-1]
            sum = prev + curr;//f[n]=f[n-1]+f[n-2]
        }
        return sum;
    }
}
