package offer_64;

/**
 * @author skyliuhc
 * @create 2021/5/6
 * 求1...n的和，不许用乘除法、for、while、if、else、switch、case
 *
 */
public class Solution {

    public int sumNums(int n){
        if(n==0){
            return 0;
        }
        return n+sumNums(n-1);
    }

}
