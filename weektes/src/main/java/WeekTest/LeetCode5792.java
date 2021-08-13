package WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-10-10:31 下午
 */
public class LeetCode5792 {
    public int countTriples(int n) {
        if(n<5) return 0;
        if(n==5){
            return 2;
        }//不加这两个都可以
        int res =0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <=n; k++) {
                    if(i!=j && j!=k){
                        if(i*i+j*j==k*k){
                            res++;
                        }
                    }

                }
            }
        }
        return res;
    }
}
