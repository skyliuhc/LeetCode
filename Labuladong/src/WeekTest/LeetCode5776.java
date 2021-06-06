package Labuladong.src.WeekTest;

import java.util.Arrays;

public class LeetCode5776 {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean isCan = true;
        for (int i = 0; i < 4; i++) {
            mat= rotate(mat);
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-i-1]=mat[i][j];
            }
        }
        return res;
    }
    //可以用Arrays.deepEquals来
//    private boolean xiangdeng(int[][] mat, int[][] target) {
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if(mat[i][j]!=target[i][j]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}


