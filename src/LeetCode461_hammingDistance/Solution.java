package LeetCode461_hammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int res=0;
        //自己写的
//        for(int i=0;i<32;i++){
//            res+=temp>>> i & 1;
//        }
        //这样效率高一点
        while(temp!=0){
            res+= temp&1;
            temp>>=1;
        }
        return res;
    }
}
