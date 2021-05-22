package LeetCode10_xorGame;

public class Solution {

    //当且仅当，以下两个条件至少满足一个时，Alice必胜
    //数组长度为偶数
    //初始的时候异或和为0
    public boolean xorGame(int[] nums) {
        if(nums.length%2==0){
            return true;
        }
        int res =0;
        for (int num : nums) {
            res^=num;
        }
        return res==0;
    }
}
