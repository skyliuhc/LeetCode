package LeetCode421;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        int n =nums.length;
        int res= Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                res=Math.max(res,nums[i]^nums[j]);
            }
        }
        return res;
    }
}
