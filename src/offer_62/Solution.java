package offer_62;

/**
 * @author skyliuhc
 * @create 2021/5/6
 * 圆圈数组最后剩下的数字
 */
public class Solution {
    public int lastRemaining(int n,int m){
        return f(n,m);
    }

    private int f(int n, int m) {
        if(n==1){
            return 0;
        }
        int x=f(n-1,m);
        return (m+x)%n;
    }
}
