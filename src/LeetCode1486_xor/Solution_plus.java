package LeetCode1486_xor;

/**
 * @author skyliuhc
 * @create 2021/5/7
 */
public class Solution_plus {
    //只用一次循环
    public int xorOperation(int n,int start){
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans^=(start+2*i);
        }
        return ans;
    }

}
