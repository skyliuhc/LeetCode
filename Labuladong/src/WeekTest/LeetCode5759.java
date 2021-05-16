package WeekTest;

import java.util.LinkedList;

// 找出所有子集的异或总和再求和
public class LeetCode5759 {
    //先找子集合，再做xor和
    int res = 0;

    public int subsetXORSum(int[] nums) {
        dp(nums, 0, new LinkedList<>());
        return res;
    }

    void dp(int[] nums, int index, LinkedList<Integer> temp) {
        if (index >= nums.length) {
            int tempresult = 0;
            for (int i = 0; i < temp.size(); i++) {
                tempresult ^= temp.get(i);
            }
            res += tempresult;
            return;
        }
        temp.add(nums[index]);
        dp(nums, index + 1, temp);
        temp.removeLast();
        dp(nums, index + 1, temp);
    }

    public static void main(String[] args) {
        int[] test = {1, 3};
        LeetCode5759 l1 = new LeetCode5759();
        l1.subsetXORSum(test);
    }
}
