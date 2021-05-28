package Hot39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates,target,0,new ArrayList<>());
        return res;
    }

    void dfs(int[] candidates,int target,int index,List<Integer> list){
        if(index==candidates.length){
            return;
        }
        if (0==target){
//            res.add(list);
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates,target,index+1,list);
        if (target-candidates[index]>=0){
            list.add(candidates[index]);
            dfs(candidates,target-candidates[index], index,list);
            list.remove(list.size()-1);
        }
    }
}
