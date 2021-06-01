package Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int x){
        this.val =x;
    }
    TreeNode(int x ,TreeNode l,TreeNode r){
        this.val = x;
        this.left=l;
        this.right=r;
    }

}
