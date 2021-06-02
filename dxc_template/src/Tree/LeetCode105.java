package Tree;

import java.util.HashMap;

public class LeetCode105 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        //开始就是根节点
        int val = preorder[pl];
        //中序遍历的根节点
        int k = map.get(val);
        int len = k - il;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, inorder, pl + 1, pl + len, il, k - 1);
        root.right = dfs(preorder, inorder, pl + len + 1, pr, k + 1, ir);
        return root;
    }
}
