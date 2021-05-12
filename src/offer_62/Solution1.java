package offer_62;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution1 {

    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

}
