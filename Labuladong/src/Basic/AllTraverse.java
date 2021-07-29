package Labuladong.src.Basic;

/**
 * @author skyliuhc
 * @create 2021/5/8
 */
public class AllTraverse {


    /**
     * 数组的遍历
     * @author skyliuhc
     * @date 2021/5/8
     * @param arr1
     * @return void
     */
    public void traverse(int[] arr1){
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    class ListNode{
        int val;
        ListNode next;
    }
    /**
     * 通过迭代进行遍历链表
     * @author skyliuhc
     * @date 2021/5/8
     * @param head
     * @return void
     */
    public void traverse(ListNode head){
        for (ListNode p=head;p!=null;p=p.next){
            System.out.println(p.val);
        }
    }
    /**
     * 递归进行链表的访问
     * @author skyliuhc
     * @date 2021/5/8
     * @param head
     * @return void
     */
    void recurTraverse(ListNode head){
        //递归访问p.val
        recurTraverse(head.next);
    }
    class TreeNode{
        int val;
        TreeNode left,right;
    }

    void traverse(TreeNode root){
        //  前序遍历 System.out.println(root.val);
        traverse(root.left);
        // 中序遍历  System.out.println(root.val);
        traverse(root.right);
        // 后序遍历  System.out.println(root.val);
    }

    class NTreeNode{
        int val;
        NTreeNode[] children;
    }

    void traverse(NTreeNode root){
        for (NTreeNode child: root.children){
            traverse(child);
        }
    }


}
