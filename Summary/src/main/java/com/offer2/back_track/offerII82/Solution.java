package com.offer2.back_track.offerII82;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-05-10:14 上午
 */
class Solution {
    //含有重复元素集合的组合
    int[] candidates;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int n;
    int k;
    int pathSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.n = candidates.length;
        this.k = target;
        back_track(0);
        return res;
    }
    public void back_track(int idx){
        if(pathSum>=k){
            if(pathSum==k){
                res.add(new ArrayList<>(path));
            }
        }
        if(idx==n){
            return ;
        }
        for(int i=idx;i<n;i++){
            if(idx<i && candidates[i-1]==candidates[i]){//这一步就是来去重
                continue;
            }
            path.add(idx);
            pathSum+=candidates[i];
            back_track(idx+1);
            path.remove(path.size()-1);
            pathSum-=candidates[i];
            back_track(idx+1);
        }
    }
}