package offer_68I;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode ancestor=root;
        while (true){
            if(p.val <ancestor.val &&q.val < ancestor.val){
                ancestor=ancestor.left;
            }else if(p.val >ancestor.val &&q.val > ancestor.val){
                ancestor=ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }

}
