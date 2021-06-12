package Hot128;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashMap {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            //只会进入循环一次
            if (!set.contains(num - 1)) {
                int currNum = num;
                int curr = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }

}
