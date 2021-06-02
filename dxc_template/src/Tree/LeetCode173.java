package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode173 {
    class BSTIterator {

        Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode p = stack.peek();
            stack.pop();
            int res = p.val;
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            return res;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        String s ="123";
    }
}
