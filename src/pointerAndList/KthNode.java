package pointerAndList;

//输入一个链表，输出该链表中倒数第k个结点。
//快慢指针，快的先走k，然后和慢的一起走，等快的走到头，慢的就到了倒数第k了
public class KthNode {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p,q;
        for (p=q=head;p!=null;p=p.next,k--){
            if (k<=0)q=q.next;
        }
        return k<=0? q:null;
    }
}
