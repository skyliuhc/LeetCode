package LeetCode1707_maximizeXor;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //暴力求解超时，60/67
//    public int[] maximizeXor(int[] nums, int[][] queries) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        int qlength = queries.length;
//        int min = nums[0];
//        int max = nums[len-1];
//        int[] res = new int[qlength];
//        for (int i = 0; i < qlength; i++) {
//            int[] temp =queries[i];
//            int xi = temp[0];
//            int mi = temp[1];
//            if(mi<min){
//                res[i]=-1;
//            }else{
//                int j =0;
//                int t=0;
//                while(j<len&&nums[j]<=mi ){
//                    t=Math.max(t,nums[j]^xi);
//                    j++;
//                }
//                res[i]=t;
//            }
//        }
//        return res;
//    }
    // 使用前缀树
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ = queries.length;
        int[][] newQueries = new int[numQ][3];
        for (int i = 0; i < numQ; ++i) {
            newQueries[i][0] = queries[i][0];//xi
            newQueries[i][1] = queries[i][1];//mi
            newQueries[i][2] = i;//对应的序号
        }
        //将mi从小到大排，这样前面插入的数组也能用
        Arrays.sort(newQueries, new Comparator<int[]>() {
            public int compare(int[] query1, int[] query2) {
                return query1[1] - query2[1];
            }
        });

        int[] ans = new int[numQ];
        Trie trie = new Trie();
        int idx = 0, n = nums.length;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < n && nums[idx] <= m) {
                //插入比mi小的树
                trie.insert(nums[idx]);
                ++idx;
            }
            if (idx == 0) { // 字典树为空
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMaxXor(x);
            }
        }
        return ans;
    }
}

class Trie {
    static final int L = 30;//10^9 2^30=1,073,741,824
    Trie[] children = new Trie[2];

    public void insert(int val) {
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;//
            if (node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
        }
    }

    public int getMaxXor(int val) {
        int ans = 0;
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit ^ 1] != null) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.children[bit];
        }
        return ans;
    }


}
