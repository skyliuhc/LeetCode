package LeetCode1486_xor;

/**
 * @author skyliuhc
 * @create 2021/5/7
 */
class Solution {
    public int xorOperation(int n, int start) {
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=start+2*i;
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res^=nums[i];
        }
        return res;
    }
}