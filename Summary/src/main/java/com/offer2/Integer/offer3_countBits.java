package com.offer2.Integer;

/**
 * @author skyliuhc
 * @create 2021-08-09-11:19 下午
 */
public class offer3_countBits {
    class Solution {
        public int[] countBits(int n) {
            int ans[] = new int[n+1];
            for(int i = 0;i <= n;i++) {
                if((i&1)==0){ //偶数
                    ans[i] = ans[i>>1];
                }else{ //奇数
                    ans[i] = ans[i-1]+1;
                }
            }
            return ans;
        }
    }

}
