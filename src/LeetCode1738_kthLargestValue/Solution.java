package LeetCode1738_kthLargestValue;

import java.util.*;

public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int n =matrix.length;
        int m = matrix[0].length;
        int total_num=n*m;//元素的总数
        List<Integer> res = new ArrayList<>();
        int[][] s = new int[n+1][m+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                s[i+1][j+1]=s[i][j+1]^s[i+1][j]^s[i][j]^matrix[i][j];
                res.add(s[i+1][j+1]);
            }
        }
        Collections.sort(res, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return res.get(k - 1);
    }


}
