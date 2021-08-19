package com.huawei;

import java.util.*;

import java.util.ArrayList;

/**
 * @author skyliuhc
 * @create 2021-08-18-7:40 下午
 */
public class Main2 {

    static List<List<Integer>> res;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();//总价
        int m = sc.nextInt();//商品件数
        int[] price = new int[m];
        vis = new boolean[m];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            price[i] = sc.nextInt();
            min = Math.min(min, price[i]);
        }
        if (min > x) {
            System.out.println(-1);
        } else {
            combinationSum(price, x);
            System.out.println(res.size());
        }

    }


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

        if (target - candidates[index] >= 0 && !vis[index]) {
            list.add(candidates[index]);
            vis[index] = true;
            dfs(candidates, target - candidates[index], index, list);
            list.remove(list.size() - 1);
            vis[index] = false;
            
        }
    }
}
