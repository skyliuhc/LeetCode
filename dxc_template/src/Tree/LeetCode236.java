package Tree;

public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //左子树包含p和q不，不包含返回右子树
        if(left==null){
            return right;
        }
        //右子树包含p和q不，不包含返回左子树
        if(right==null){
            return left;
        }
        //都包含的话就是root
        return root;
    }
}
