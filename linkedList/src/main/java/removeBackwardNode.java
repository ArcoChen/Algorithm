import java.util.Stack;

/**
 * leetcode
 *
 * @author huangjiachang
 * @date 2023/7/10
 */
public class removeBackwardNode {

    /**
     *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *  输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */

    /**
     * 思考
     * <p>
     * 1. 先计算数组的长度，再遍历链表，但遍历元素达到size-index时，说明已经遇到需要删除的元素，将node的next指向node.next.next
     * <p>
     * 2. 双指针法，定义一个快指针，一个慢指针
     * <p>
     * 3. 利用栈，先压入栈中，弹出栈的第n个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点
     */

    public static void main(String[] args) {

    }

    /**
     * 先计算长度，再删除
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        if (head == null) {
            return head;
        }
        int count = getListNodeLength(head);
        ListNode current = dummyNode;
        for (int i = 0; i < count - n + 1; i++) {
            current = head.next;
        }
        current.next = current.next.next;
        return dummyNode.next;
    }

    public static int getListNodeLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /**
     * 双指针
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0, head);
        ListNode fast = head, slow = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode current = dummyNode;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummyNode.next;

    }
}
