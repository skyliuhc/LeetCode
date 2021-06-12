package Hot85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0){
            return 0;
        }
        int m = matrix[0].length;
        int[][] matrixNew = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (matrix[0][i]== '1'){
                matrixNew[0][i] = 1;
            }
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]=='1'){
                    matrixNew[i][j] = matrixNew[i-1][j]+1;
                }
            }
        }
        //前面是预处理部分
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrixNew[i][j]*m<=ans){
                    //如果说给它最大的宽还是比不过最大值，直接跳过
                    continue;
                }
                if (matrixNew[i][j]!=0){
                    int cnt =1;
                    for (int k = j+1; k <m ; k++) {
                        if(matrixNew[i][k]<matrixNew[i][j]){
                            break;
                        }
                        cnt++;
                    }
                    for (int k = j-1; k >=0 ; k--) {
                        if(matrixNew[i][k]<matrixNew[i][j]){
                            break;
                        }
                        cnt++;
                    }
                    ans =Math.max(ans,cnt*matrixNew[i][j]);
                }
            }
        }
        return ans;
    }
}
