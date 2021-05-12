package offer_65;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {
    public int add(int a, int b) {
        //无进位和 等价于异或
        //进位等价于与运算
        //如果有进位的化就一直加
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

}
