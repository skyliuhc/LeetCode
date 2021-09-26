package com.redbook.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-19-5:08 下午
 */
public class Alpha extends Base {
    public static void main(String[] args) {
//        new Alpha();
//        new Base();
//        byte b = 1;
        System.out.println(countWays(4));
    }

    public static int countWays(int num) {
        int[] coins = {1, 2, 3};
        List<List<Integer>> lists = combinationSum(coins, num);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        return lists.size();
    }


    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    static void dfs(int[] candidates, int target, int index, List<Integer> list) {
        if (index == candidates.length) {
            return;
        }
        if (0 == target) {
            // res.add(list);
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, target, index + 1, list);
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, list);
            list.remove(list.size() - 1);
        }
    }


}
