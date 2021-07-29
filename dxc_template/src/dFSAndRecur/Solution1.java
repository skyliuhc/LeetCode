package dFSAndRecur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-07-27-10:04 上午
 */
public class Solution1 {
    //数为dp
    static int get(List<Integer> list, int l, int r) {
        int res = 0;
        for (int i = l; i >= r; i--) {
            res = res * 10 + list.get(i);
        }
        return res;
    }

    static int power10(int x) {//10的x次方
        int res = 1;
        while (x != 0) {
            res *= 10;
            x--;
        }
        return res;
    }

    //统计从1-n，x出现的次数
    static int count(int n, int x) {
        if (n == 0) return 0; //如果n为0，那直接返回0就行了
        List<Integer> l = new ArrayList<Integer>();

        //将n的每一位加入到l中
        while (n != 0) {
            l.add(n % 10);
            n /= 10;
        }
        int len = l.size();

        //对于0,不需要枚举最高位
        int res = 0;
        for (int i = len - 1 - (x == 0 ? 1 : 0); i >= 0; i--) {
            if (i < len - 1) {
                res += get(l, len - 1, i + 1) * power10(i);
                if (x == 0) res -= power10(i);
            }

            if (l.get(i) > x) res += power10(i);
            else if (l.get(i) == x) res += get(l, i - 1, 0) + 1;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        int n = 123;
        List<Integer> l = new ArrayList<Integer>();
        //将n的每一位加入到l中
        while (n != 0) {
            l.add(n % 10);
            n /= 10;
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        int i = power10(3);//
        System.out.println(i);

    }


}
