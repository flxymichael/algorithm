package pointerAndList;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNode {
    //用链表循环的方式替代了长链表指针先走k步这一步骤。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1==null||pHead2==null)return null;
            ListNode p1 = pHead1,p2=pHead2;
            while (p1!=p2){
                p1= p1==null? pHead2:p1.next;
                p2= p2==null? pHead1:p2.next;
            }
            return p2;
    }
}
