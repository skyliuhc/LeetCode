package forJob.hot_for_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author skyliuhc
 * @create 2021-07-10-7:26 下午
 */
public class threeOrders {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            this.val = x;
            this.left = l;
            this.right = r;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    public int[][] threeOrders(TreeNode root) {
        traverse(root);
        int n = pre.size();
        int[][] ans = new int[3][n];
        for (int j = 0; j < n; j++) {
            ans[0][j] = pre.get(j);
            ans[1][j] = in.get(j);
            ans[2][j] = post.get(j);
        }
        return ans;
    }

    void traverse(TreeNode root) {
        if(root==null){
            return ;
        }
        pre.add(root.val);
        traverse(root.left);
        in.add(root.val);
        traverse(root.right);
        post.add(root.val);
    }
    //array转int数组
    private static final int[] toIntArray(ArrayList<Integer> arrayList){
        int[] intArray = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }
    //非递归显示前序中序遍历
    //前序遍历的非递归实现
    public LinkedList<Integer> preOrder(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
        }

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            list.add(current.val);
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
        }

        return list;
    }
    //利用栈，先进后出
    //先序遍历
    public static void preOrderUnRecur(TreeNode root) {
        System.out.print("pre-order: ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);//后加入左节点，先访问左节点
                }
            }
        }
        System.out.println();
    }
    //中序遍历
    public static void inOrderUnRecur(TreeNode root) {
        System.out.print("in-order: ");
        if(root !=null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || root!=null){
                if (root !=null){
                    stack.push(root);
                    root=root.left;
                }else{
                    root = stack.pop();
                    System.out.print(root.val+" ");
                    root = root.right;

                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void postOrderUnRecur(TreeNode root){
        System.out.println("in-order: ");
        if (root!=null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while(!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if(root.left!=null){
                    s1.push(root.left);
                }
                if(root.right!=null){
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop()+" ");
            }
        }
        System.out.println();
    }

}
