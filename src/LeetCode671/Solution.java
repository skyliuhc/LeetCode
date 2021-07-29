package LeetCode671;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-07-27-12:16 上午
 */
public class Solution {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    HashSet<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        int n =set.size();
        if (n==1){
            return -1;
        }
        int[] t = new int[n];
        Iterator it = set.iterator();
        int i=0;
        while(it.hasNext()){
            t[i]= (int) it.next();
        }

        Arrays.sort(t);

       return t[1];
    }
    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
