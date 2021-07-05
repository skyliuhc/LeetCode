package Labuladong.src.Dynamtic;

/**
 * @author skyliuhc
 * @create 2021-07-03-10:38 上午
 */
public class LeetCode1137_tribonacci {
    //滚动数组
    public int tribonacci(int n) {
        if (n < 3) return n == 0 ? 0 : 1;
        int sum, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; i++) {
            sum = x + y + z;
            x = y;
            y = z;
            z = sum;
        }
        return z;
    }
}
