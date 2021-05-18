package LeetCode1442_countTriplets;

public class Solution {
    //异或和的三元组
    //源问题转化为Si=Sk+1
    public int countTriplets(int[] arr) {
        //先求前缀数组,要多开一个好用递推公式
        int n = arr.length;
        int[] s=new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1]=s[i]^arr[i];
        }
        int ans =0;
        //三重循环
        //注意i,j,k的范围
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                for (int k = j; k < n; k++) {
                    if(s[i]==s[k+1]){
                        ans++;
                    }
                }
            }

        }
        return ans;
    }


}
