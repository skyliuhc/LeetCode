package LeetCode1442_countTriplets;

public class Solution1 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] xorSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            xorSum[i+1]=xorSum[i]^arr[i];
        }
        int ans =0;
        //两重循环
        for (int i = 0; i < n; i++) {
            for (int k = i+1; k <n ; k++) {
                if(xorSum[i]==xorSum[k+1]){
                    //s[i] = s[k+1]
                   ans+=k-i;
                   //j的范围 i+1~k
                }
            }
        }
        return ans;
    }


}
