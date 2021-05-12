package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author skyliuhc
 * @Description
 * @Date 2021-05-09-10:13 上午
 */
public class LeetCode111 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            //root 本身就是一层，depth初始化为1
            int depth = 1;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    /*判断是否到达终点*/
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }
                    /*将cur的相邻节点加入队列*/
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
}
