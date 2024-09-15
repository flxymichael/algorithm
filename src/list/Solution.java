package list;

public class Solution {

    public static void main(String[] args) throws InterruptedException {

        Solution solution = new Solution();
        ListNode listNode = solution.initList();
        System.out.println("原始链表");
        solution.printList(listNode);

        ListNode listNode1 = solution.reverseBetween(listNode, 2, 5);
        System.out.println();
        System.out.println("区间反转后的链表");
        solution.printList(listNode1);

    }

    public ListNode initList() throws InterruptedException {
        ListNode head = new ListNode(0);
        ListNode flag = head;
        for (int i = 1; i < 10; i++) {
            flag.next = new ListNode(i);
            flag = flag.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 使用快慢指针检测循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("链表存在循环！");
                return; // 或者你可以选择在这里处理循环，比如打印循环部分
            }
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    /*
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /*
     * 反转链表m到n
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (head == null || head.next == null || m >= n) {


            return head;
        }

        ListNode dummy = new ListNode(-1);


        dummy.next = head;
        ListNode pre = dummy;
        ;
        ListNode cur = head;

        for (int i = 0; i < m - 1; i++) {
            pre = cur;
            cur = cur.next;
        }

        for (int i = 0; i < n - m; i++) {


            ListNode tmp = cur.next;
            cur.next = pre.next;
            ;
            pre.next = cur;
            cur = tmp;
        }


        return dummy.next;
    }
}
