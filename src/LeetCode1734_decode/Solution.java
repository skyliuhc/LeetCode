package LeetCode1734_decode;

public class Solution {

    public int[] decode(int[] encoded){
        int n = encoded.length+1;
        int total =0;
        //前n个正整数，不包括0
        for (int i = 1; i <=n; i++) {
            total^=i;
        }
        int odd =0;
        //奇数从1开始
        for (int i = 1; i < n-1; i+=2) {
            odd^=encoded[i];
        }
        int[] perm =new int[n];
        perm[0]=total^odd;
        for (int i = 0; i < n-1; i++) {
            perm[i+1]=perm[i]^encoded[i];
        }
        return perm;
    }

    public static void main(String[] args) {

    }
}
