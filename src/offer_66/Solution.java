package offer_66;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {

    public int[] constructArr(int[] a){
        if(a.length==0){
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0]=1;
        int temp=1;
        for (int i = 1; i < a.length; i++) {
            b[i]=b[i-1]*a[i-1];
        }
        for (int i = a.length-2; i>=0; i--) {
            temp*=a[i+1];
            b[i]*=temp;
        }
        return b;
    }
}
