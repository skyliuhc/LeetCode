package com.acwing.offer_week1;


import java.util.HashMap;

/**
 * @author skyliuhc
 * @create 2021-08-10-3:59 下午
 */
public class offer18_buildTree {
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

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] _pre, _in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        _pre = preorder;
        _in = inorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++) map.put(inorder[i], i);
        return dfs(0, n - 1, 0, n - 1);
    }

    TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(_pre[pl]);
        int k = map.get(root.val);//根在中序遍历的位置，以此来定位
        int len = k-il+1;//左子树的长度
        root.left = dfs(pl+1,pl+len-1,il,k-1);
        root.right = dfs(pl+len,pr,k+1,ir);
        return root;
    }


}
