package pointerAndList;

public class MergeList {
    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

    //递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list2.next, list1);
            return list2;
        }
    }

    //迭代
    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(-1);
        ListNode pre = tmp;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return tmp.next;
    }
}