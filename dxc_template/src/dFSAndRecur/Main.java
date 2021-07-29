package dFSAndRecur;

import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-07-27-3:26 下午
 */
public class Main {
    //蒙特利安的梦想
    static int N = 12, M = 1 << N;
    static long f[][] = new long[N][M];
    static boolean st[] = new boolean[M];
    //咋回事啊
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n, m;
        while (true) {
            n = in.nextInt();
            m = in.nextInt();
            if ((n | m) == 0) break;

            for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) f[i][j] = 0;

            for (int i = 0; i < 1 << n; i++) {
                st[i] = true;
                int cnt = 0;//cnt表示当前存在多少个连续的0
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) != 0) {
                        if (cnt % 2 != 0) st[i] = false;//判断是不是奇数
                        cnt = 0;
                    } else cnt++;
                }
                if (cnt % 2 != 0) st[i] = false;
            }
            f[0][0] = 1;
            for (int i = 1; i <= m; i++)
                for (int j = 0; j < 1 << n; j++)
                    for (int k = 0; k < 1 << n; k++)
                        if ((j & k) == 0 && (st[j | k]))
                            f[i][j] += f[i - 1][k];
            System.out.println(f[m][0]);
        }
    }
}