package Labuladong.src.WeekTest;

import java.util.Arrays;

public class LeetCode5764 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 20000000;
        while (l < r) {
            int mid = l + r >> 1;
            if (get(dist, mid) <= hour) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (r == 20000000) return -1;//说明无解
        return r;
    }

    private double get(int[] dist, int mid) {
        double res = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            res += (dist[i] + mid - 1) / mid;//向上取整
        }
        System.out.println("############");
        System.out.println((double) dist[dist.length - 1] / mid);//0.0100000010000001正确
        System.out.println("两个int做除法"+dist[dist.length - 1] / mid);
        System.out.println((double) (dist[dist.length - 1] / mid));//0 错误
        System.out.println("############");
        return res + (double) dist[dist.length - 1] / mid;//最后一个不用向上取整
    }

    public static void main(String[] args) {
        int[] dist= new int[]{1,1,100000};
        double mid =2.01;
        LeetCode5764 l1 = new LeetCode5764();
        l1.minSpeedOnTime(dist,mid);
    }
}
