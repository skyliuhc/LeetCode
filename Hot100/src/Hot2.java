public class Hot2 {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode (int val){
            this.val=val;
        }
        ListNode(int val, ListNode Next){
            this.val = val;
            this.next =Next;
        }
    }
    //我的写法 是错误的
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode tail = new ListNode();
//        int p1 =0,p2=0;
//        int sum1=0;
//        int sum2 =0;
//        while (l1!=null){
//
//            sum1+=l1.val*Math.pow(10,p1);
//            p1++;
//            l1=l1.next;
//        }
//        while (l2!=null){
//            sum2+=l2.val*Math.pow(10,p2);;
//            p2++;
//            l2=l2.next;
//        }
//        int sum=sum1+sum2;
//        tail.val=sum%10;
//        sum=sum/10;
//        ListNode head = tail;
//        while (sum/10!=0){
//            int tempVal=sum%10;
//            ListNode temp = new ListNode(tempVal);
//            tail.next=temp;
//            tail=tail.next;
//            sum=sum/10;
//        }
//        return head;
//    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = null, tail=null;
        int carry = 0;
        while (l1!=null||l2!=null){
            //空的链表就相当于0
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum=n1+n2+carry;
            if (head==null){
                head=tail=new ListNode(sum%10);
            }else{
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry =sum /10;
            if(l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (carry>0){
            tail.next=new ListNode(carry);
        }
        return head;
    }
    //beautiful
    public ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode p1=l1,p2=l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1!=null||p2!=null||carry>0){
            newVal=(p1==null?0: p1.val)+(p2==null?0:p2.val)+carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1=p1==null?null:p1.next;
            p2=p2==null?null:p2.next;
            p=p.next;
        }
        return dummy.next;
    }


}
