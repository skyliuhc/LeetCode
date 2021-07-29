package Labuladong.src.WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-18-10:39 上午
 */
public class LeetCode5814 {
    public int addRungs(int[] r, int dist) {
        int start=0;
        int res=0;
        for (int i = 0; i < r.length; i++) {
            res+=(r[i]-start-1)/dist;
            start=r[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5814 l = new LeetCode5814();
        int[] t ={1,3,5,10};
        int dist = 2;
        System.out.println(l.addRungs(t,dist));
    }
}
