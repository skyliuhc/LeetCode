package LeetCode1310_xorQueries;

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n= queries.length;
        int[] res=new int[n];
        for (int i = 0; i <n ; i++) {
            int temp=0;
            if(queries[i][0]==queries[i][1]){
                temp=arr[queries[i][0]];
            }else{
                for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                    temp^=arr[j];
                }
            }
            res[i]=temp;
        }
        return res;
    }

}
