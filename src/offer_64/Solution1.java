package offer_64;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution1 {
    public int sumNums(int n){
        boolean flag=n>0&&(n+=sumNums(n-1))>0;
        return n;
    }

}
