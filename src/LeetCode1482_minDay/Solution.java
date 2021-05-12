package LeetCode1482_minDay;

/**
 * @Author skyliuhc
 * @Description
 * @Date 2021-05-09-11:37 上午
 */
public class Solution {

    public int minDay(int[] bloomDay,int m,int k){
        if(k*m>bloomDay.length){
            return -1;
        }
        int low=1,high=1;
        int length=bloomDay.length;
        for (int i = 0; i < length; i++) {
            high=Math.max(high,bloomDay[i]);
        }
        while(low<high){
            int days=(high-low)/2+low;
            if (canMake(bloomDay,days,m,k)){
                high=days;
            }else{
                low=days+1;
            }
        }
        return low;
    }
    /**
     *功能描述
     * @author skyliuhc
     * @date 2021/5/9
     * @param bloomDay
        days 制定天数
        m 束花
        k 一束花里面要k朵
     * @return boolean
     */
    public boolean canMake(int[] bloomDay,int days,int m,int k){
        int bouquets=0;
        int flowers = 0;
        int length =bloomDay.length;
        for (int i = 0; i < length && bouquets<m; i++) {
            if(bloomDay[i]<=days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }else {
                    flowers=0;
                }
            }
            return bouquets>=m;
        }



    }


