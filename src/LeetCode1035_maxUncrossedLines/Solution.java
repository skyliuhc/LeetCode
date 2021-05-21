package LeetCode1035_maxUncrossedLines;

public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n =nums2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            int num1= nums1[i-1];
            for (int j = 1; j <=n; j++) {
                    int num2=nums2[j-1];
                    if(num1==num2){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 =new int[]{1,4,2};
        int[] nums2 =new int[]{1,2,4};
        Solution s = new Solution();
        System.out.println(s.maxUncrossedLines(nums1, nums2));

    }
}
