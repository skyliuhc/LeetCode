package LinkedList;

public class LeetCode237 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void deleteNode(ListNode node) {
        //删除链表中的节点
        //假装删除node,就是用node来取代下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
