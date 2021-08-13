package com.acwing.offer_week1;

/**
 * @author skyliuhc
 * @create 2021-08-10-4:36 下午
 */
public class offer19_inorderSuccessor {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode father;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public TreeNode inorderSuccessor(TreeNode p) {
        if (p == null) return null;
        TreeNode curr = p;
        if (curr.right != null) {//有右节点就一直找到右子树的最左节点
            curr = curr.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        //没有右子树
        while (curr.father != null) {  //向上判断父节点,直到父节点的第一个左节点
            if (curr.father.left == curr) {
                return curr.father;
            }
            curr = curr.father;
        }
        return null;
    }


}
