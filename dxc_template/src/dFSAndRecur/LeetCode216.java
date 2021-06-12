package dFSAndRecur;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {

    List<Integer> t;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, 1, n);
        return res;
    }

    private void dfs(int k, int start, int n) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(t));
            }
        }
        for (int i = start; i < 10; i++) {
            t.add(i);
            dfs(k - 1, i, n - i);
            t.remove(t.size() - 1);
        }
    }

}
