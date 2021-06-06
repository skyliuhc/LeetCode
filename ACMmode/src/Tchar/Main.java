package Tchar;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int N=input.nextInt();
            String s = input.next();//注意用的是next(),不换行
            char[] ch = new char[10000];
            for (int j = 0; j < N; j++) {
                ch[j]=s.charAt(j);
            }
            String test = String.valueOf(ch);
            System.out.println(solve(test));
        }
    }
    //你的函数逻辑
    private static boolean solve(String test) {
        return false;
    }


}
