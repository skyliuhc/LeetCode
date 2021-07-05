package Labuladong.src.WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-04-11:19 上午
 */
public class LeetCode5802 {
    long quick_pow(long x,long y){
        long ans=1;
        final long mod=1000000007;
        while(y>0){
            if((y&1)==1){
                ans=(ans*x)%mod;
            }
            x=(x*x)%mod;
            y>>=1;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        if(n==1)
            return 5;
        long ans=0;
        final long mod=1000000007;
        if((n&1)==1){
            long a=(n+1)/2;//偶数
            long b=(n-1)/2;//奇数
            ans=((quick_pow(5,a)%mod)*(quick_pow(4,b)))%mod;
        }
        else{
            ans=((quick_pow(5,n/2)%mod)*(quick_pow(4,n/2)))%mod;
        }

        return (int)ans;
    }


}
