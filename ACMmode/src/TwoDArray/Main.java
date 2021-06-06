package TwoDArray;


import java.util.*;
public class Main {
//    输入描述第一行是一个正整数n，表示二维数组有n行n列。
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();//定义需要的阶乘数n
        int[][] array = new int[n][n];//定义一个n*n的数组array
        System.out.println("输入数组的各个元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        //这里写你的处理逻辑
    }
}
