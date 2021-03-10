package pointerAndList;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/**
 * 在遍历的同时删除
 */
public class DuplicationNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode tmp = new ListNode(-1);
        tmp.next =pHead;

        ListNode pre = tmp;
        ListNode cur = pHead;

        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur =cur.next;
                pre.next=cur;
            }else{
                pre=cur;
                cur=cur.next;
            }

        }
        return tmp.next;
    }


}
