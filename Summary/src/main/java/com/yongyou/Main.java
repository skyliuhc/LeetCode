package com.yongyou;

/**
 * @author skyliuhc
 * @create 2021-09-12-8:01 下午
 */
public class Main {
    public static void main(String[] args) {
        int[][] input = {{2, -1}, {2, 2}, {2, 1}, {2, 0}, {2, 3}};
        if (check(input)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static boolean check(int[][] input) {
        return cond1(input) || cond2(input) || cond3(input) || cond4(input);
    }

    private static boolean cond4(int[][] input) {
        int n = input.length;
        int b = input[0][0] + input[0][1];
        for (int i = 1; i < n; i++) {
            int temp = input[i][0] + input[i][1];
            if (temp != b) {
                return false;
            }
        }
        return true;
    }

    private static boolean cond3(int[][] input) {
        int n = input.length;
        int b = input[0][1] - input[0][0];
        for (int i = 1; i < n; i++) {
            int temp = input[i][1] - input[i][0];
            if (temp != b) {
                return false;
            }
        }
        return true;

    }

    static boolean cond1(int[][] input) {
        int n = input.length;
        int x = input[0][0];
        for (int i = 1; i < n; i++) {
            if (input[i][0] != x) {
                return false;
            }
        }
        return true;
    }

    static boolean cond2(int[][] input) {
        int n = input.length;
        int y = input[0][1];
        for (int i = 1; i < n; i++) {
            if (input[i][1] != y) {
                return false;
            }
        }
        return true;
    }


}
