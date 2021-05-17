package LeetCode993_isCousins;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_BFS {

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

    int x;
    int depthX;
    TreeNode xParent;
    boolean xFound = false;

    int y;
    int depthY;
    TreeNode yParent;
    boolean yFound = false;


    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
                update(node.left, node, depth + 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                update(node.right, node, depth + 1);
            }
            if (xFound && yFound) {
                break;
            }
        }
        return xParent != yParent && depthX == depthY;
    }

    void update(TreeNode node, TreeNode Parent, int depth) {
        if (node.val == x) {
            xParent = Parent;
            depthX = depth;
            xFound = true;
        }
        if (node.val == y) {
            yParent = Parent;
            depthY = depth;
            yFound = true;
        }
    }


}
