package dFSAndRecur;

import java.util.*;

public class LeetCode78 {
    //用二进制进行状态压缩
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            //对表示对二进制代码进行解析，如果第j位是1就把它放到当前解中
            for (int j = 0; j < nums.length; j++) {
                if ((i >> j & 1) == 1) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
