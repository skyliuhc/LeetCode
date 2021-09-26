package com.qunar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-14-4:28 下午
 */
public class Main {
    static int n;
    static int ans;
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int[] nums;
    public static void main(String[] args) {
        int[] m = {-1,1,4,-9,-8};
        nums = m;
        n = m.length;
        back_track(0);
        for (int i = 0; i < res.size(); i++) {
            int temp =0;
            List<Integer> t = res.get(i);
            for (int j = 0; j < t.size(); j++) {
                temp+=t.get(j)*(j+1);
            }
            ans = Math.max(ans,temp);
        }
        System.out.println(ans);
    }

    static void back_track(int idx){
        if(idx == n){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[idx]);//选
        back_track(idx+1);
        path.remove(path.size()-1);//撤销选择
        back_track(idx+1);
    }
}
