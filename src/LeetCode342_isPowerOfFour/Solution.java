package LeetCode342_isPowerOfFour;

public class Solution {
    public boolean isPowerOfFour(int n){
        // 4 的幂出现在偶数次（从左往右），然后从这个偶次位往后全是0
        return n>0 && (n&(n-1))==0 && (n&0xaaaaaaaa)==0;
    }

}
