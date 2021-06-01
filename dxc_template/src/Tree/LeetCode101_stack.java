package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101_stack {
    public boolean isSymmetric(TreeNode root){
        return check(root,root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if (u==null && v==null){
                continue;
            }
            if ((u==null||v==null)||(u.val!=v.val)){
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);
            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
