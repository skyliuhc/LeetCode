package WeekTest;

import java.util.Arrays;

public class LeetCode5797 {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = nums[n - 1];
        int b = nums[n - 2];
        int c = nums[0];
        int d = nums[1];
        return a * b - c * d;
    }
}
