package LeetCode993_isCousins;

public class Solution_DFS {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int depthX=0;
    int depthY=0;
    TreeNode xParent;
    TreeNode yParent;
    int x;
    int y;
    boolean xFound = false;
    boolean yFound = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        //是cousin的两个条件
        //depth相同 父节点不同
        this.x = x;
        this.y = y;
        dfs(root,0,null);
        return depthX==depthY && xParent !=yParent;
    }
    //O(n) O(n)
    private void dfs(TreeNode root, int depth, TreeNode Parent) {
        if (root==null){
            return;
        }
        if(root.val==x){
            xFound=true;
            xParent=Parent;
            depthX=depth;
        }
        if (root.val==y){
            yFound = true;
            yParent = Parent;
            depthY=depth;
        }
        if(xFound&&yFound){
            return;
        }
        dfs(root.left,depth+1,root);
        //提前返回
        if(xFound&&yFound){
            return;
        }
        dfs(root.right,depth+1,root);
    }


}
