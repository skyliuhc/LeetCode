package LeetCode342_isPowerOfFour;

public class Solution1 {
    public  boolean isPowerOfFour(int n){
        // 判断是不是2的整数幂 n&(n-1)=0 再从2的整数幂中找除以3余1的是4的幂
        return n>0 && (n&(n-1)) ==0 && n%3==1;
    }

}
