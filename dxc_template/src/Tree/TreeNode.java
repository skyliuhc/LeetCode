package Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
    TreeNode(int x,TreeNode l,TreeNode r){
        this.val=x;
        this.left = l;
        this.right = r;
    }
    void traverse(TreeNode root){
        if(root==null) return;//一定要加哦
        //前序遍历
        traverse(root.left);
        //中序遍历
        traverse(root.right);
        //后序遍历
    }
}
