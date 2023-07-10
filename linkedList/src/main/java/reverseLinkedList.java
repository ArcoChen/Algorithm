

/**
 * leetcode 206 反转链表
 *
 * @author huangjiachang
 * @date 2023/7/9
 */
public class reverseLinkedList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 输入：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
     * <p>
     * 输入：head = [1,2] 输出：[2,1]
     * <p>
     * 输入：head = [] 输出：[]
     */

    /**
     * 思考
     * <p>
     * 1. 用双指针法，定义一个current指针，指向头部节点，在定义一个pre指针，初始化为null，再进行反转
     * <p>
     * 2. 递归法，逻辑和双指针一样，当current为空，循环结束不断将pre指向current
     */

    public static void main(String[] args) {
        ListNode node = new ListNode(1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        node = reverseList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 双指针法
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head, pre = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
