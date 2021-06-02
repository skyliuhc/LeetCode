package Tree;

public class LeetCode124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    //返回root往下走的最大值
    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans= Math.max(ans,left+root.val+right);
        return Math.max(0,root.val+Math.max(left,right));
    }
}
