package com.redbook.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author skyliuhc
 * @create 2021-09-18-10:10 上午
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        char[][] grid = new char[r][c];
        int x = 0;
        int y = 0;
        int[] start = new int[2];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'R') {
                    x = i;
                    y = j;
                    start[0] = x;
                    start[1] = y;
                }
            }
        }
        System.out.println("开始的位置"+start[0]+" "+start[1]);


        System.out.println("x:" + x + "y:" + y);
//        int[] dx = new int[]{0, 1, 0, -1};
//        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0,-1};

        int di = 0;
        int len = 0;
        int T = Integer.parseInt(br.readLine());
        System.out.println("T->" + T);
        while (T-- > 0) {
            String command = br.readLine();
            System.out.println("command:-->" + command + "xxx");
            if (command.equals("Turn right")) {
                di = (di + 1) % 4;
                System.out.println("Turn right:"+di+"dx:"+dx[di]+"dy"+dy[di]);
            } else if (command.equals("Turn left")) {
                di = (di + 3) % 4;
                System.out.println("Turn left:"+di+"dx:"+dx[di]+"dy"+dy[di]);
            } else {
                String[] fn = command.split(" ");
                len = Integer.parseInt(fn[1]);
                System.out.println("len:" + len);
                for (int i = 0; i < len; i++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if ((nx >= 0 && nx < r) && (ny >= 0 && ny < c)) {
                        if (grid[nx][ny] != 'O') {
                            x = nx;
                            y = ny;
                        }
                    }
                    System.out.println("移动之后的位置(x,y):"+x+","+y);
                }
            }
        }
        int p1 = x - start[0];
        int p2 = y - start[1];
        System.out.println("x:"+x+"y:"+y);
        System.out.println(p1 + " " + p2);
        br.close();
    }
//    3 6 // R行 C列，B是空地，O是障碍，R是机器人（初始朝向向上），  1<= R, C <=100
//
//   BBBBBB
//   BRBOBB
//   BBBOBB
//
//6 // 6条指令 , 指令数<=1000
//
//    Turn right // (2, 2) 朝右
//
//    Forward 3 // (2, 2) -> (2，3) 遇上障碍
//
//    Turn left // (2, 3) 朝上
//
//    Forward 2 // (1, 3) 遇上边界
//
//    Turn left // (1, 3) 朝左
//
//    Forward 1 // (1, 2)

}