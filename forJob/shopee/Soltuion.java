package forJob.shopee;

/**
 * @author skyliuhc
 * @create 2021-07-02-5:27 下午
 */
public class Soltuion {
    //花瓣
    public int petalsBreak(int[] petals) {
        int n = petals.length;
        int res =0;
        for (int i = 0; i < n; i++) {
            if(petals[i]%2==1){
                res++;
                res+=(petals[i]-1)/2;
            }else {
                res+=(petals[i])/2;
            }

        }
        return res;
    }
}
