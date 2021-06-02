package Tree;

public class LeetCode543 {
    public int ans;
    //求树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    //枚举所有的最高点
    public int dfs(TreeNode root){
        //返回的是以root为起点的最长路径
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        ans=Math.max(ans,left+right);
        return Math.max(left+1,right+1);
    }
}
