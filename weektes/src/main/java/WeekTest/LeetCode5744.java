package WeekTest;

public class LeetCode5744 {
    //旋转盒子
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        //先翻转
        for (int i = 0; i < n; i++) {
            for (int j = m - 1, k = 0; j >= 0; j--, k++) {
                res[i][k] = box[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1, k = n; j >= 0; j--) {
                if (res[j][i] == '*') {
                    //如果是固定障碍物
                    k = j;
                } else if (res[j][i] == '#') {
                    //如果是石头
                    res[j][i] = '.';
                    res[--k][i] = '#';
                }
            }
        }
        return res;
    }
//之前想的思路
//    void swap(char[] arr, int a, int b) {
//        char temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }

    public static void main(String[] args) {
        LeetCode5744 l1 = new LeetCode5744();
        char[][] test = {{'#', '.', '#'}};
        l1.rotateTheBox(test);
    }


}
