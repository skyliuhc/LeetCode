package Tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {
    List<Integer> res;
    //中序遍历，加提前返回，虽然能过但是并不是很快
    public boolean isValidBST(TreeNode root) {
        res = new ArrayList<>();
        return dps(root);
    }

    boolean dps(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (dps(root.left)) {
            if (res.size() != 0) {
                if (res.get(res.size() - 1) < root.val) {
                    res.add(root.val);
                } else {
                    return false;
                }
            } else {
                res.add(root.val);
            }
            return dps(root.right);
        }
        return false;
    }

    public boolean isValidBST1(TreeNode root) {
        traverse(root);
        for (int i = 0; i < res.size()-1; i++) {
            if(res.get(i)<res.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void traverse(TreeNode root) {
        if(root ==null){
            return;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }


}
