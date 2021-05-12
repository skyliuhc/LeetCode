package offer_68II;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val=x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||p==root||q==root){
            return root;
        }
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        //l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
        //l、r 任一为空，说明 LCA 位于另一子树或其祖先中
        return l==null ?r:(r==null?l:root);
    }

}
