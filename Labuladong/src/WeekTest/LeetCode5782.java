package Labuladong.src.WeekTest;

public class LeetCode5782 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] f = new long[n][2];
        f[0][0] = nums[0];
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            //长度为奇数的最大交替和
            f[i][0] = Math.max(f[i - 1][0], Math.max(nums[i], f[i - 1][1] + nums[i]));
            //长度为偶数的最大交替和
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - nums[i]);
        }
        return f[n - 1][0];
    }
}
