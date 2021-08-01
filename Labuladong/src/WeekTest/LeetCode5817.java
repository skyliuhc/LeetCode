package Labuladong.src.WeekTest;

/**
 * @author skyliuhc
 * @create 2021-08-01-11:02 上午
 */
//第252场双周赛
public class LeetCode5817 {
    public long minimumPerimeter(long neededApples) {
        long l =1,r=1000;
        while(l<=r){
            long mid =(r+l)/2;
            if(get(mid)<neededApples){
                l=mid+1;
            }else{
                r=mid;
            }
            System.out.println(mid);
        }
        return l;

    }
    long get(long x){
        //n^2的求和公式是 n(n+1)(2n+1)/6
        //计算苹果的时候用转圈法，不然容易算错
        return 2*x*(x+1)*(2*x+1);
    }

    public static void main(String[] args) {
        LeetCode5817 l1 = new LeetCode5817();
        l1.minimumPerimeter(1);
    }
}
