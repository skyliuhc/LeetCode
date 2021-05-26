package LeetCode461_hammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int res=0;
        for(int i=0;i<32;i++){
            res+=temp>>> i & 1;
        }

        return res;
    }
}
