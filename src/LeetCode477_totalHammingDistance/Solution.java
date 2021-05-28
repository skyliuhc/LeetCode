package LeetCode477_totalHammingDistance;

public class Solution {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int j = 0; j < 30; j++) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c += (nums[i] >> j) & 1;
            }
            res += c * (n - c);
        }
        return res;
    }
}
