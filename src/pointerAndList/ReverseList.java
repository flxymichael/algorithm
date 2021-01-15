package pointerAndList;

public class ReverseList {
    //非递归
    public ListNode ReverseList(ListNode head) {
        if (head==null)return null;
        ListNode node =head;
        ListNode pre = null;
        ListNode next = null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
    //递归
    public ListNode ReverseList2(ListNode head){
        return Reverse(head,null);
    }

    public  ListNode  Reverse(ListNode current,ListNode pre){
        if (current==null)return pre;
        ListNode tmp  = current.next;
        current.next  = pre;
        return Reverse(tmp,current);
    }

}
