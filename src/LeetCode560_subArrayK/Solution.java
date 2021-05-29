package LeetCode560_subArrayK;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int count =0;
        //O(n^2) O(1)
        for (int start = 0; start <nums.length ; start++) {
            int sum =0;
            for (int end = start; end >=0; end--) {
                sum+=nums[end];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }

}
