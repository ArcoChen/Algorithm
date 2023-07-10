import com.alibaba.fastjson2.JSONObject;
import java.util.jar.JarEntry;

/**
 * leetcode 203 移除链表元素
 *
 * @author huangjiachang
 * @date 2023/7/9
 */
public class removeNode {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * <p>
     * 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     * <p>
     * 输入：head = [], val = 1 输出：[]
     * <p>
     * 输入：head = [7,7,7,7], val = 7 输出：[]
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
            new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        //removeElements(head,7);
        removeElements1(head,7);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 递归
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 使用虚拟头部节点，把head加入到虚拟头部节点中，这样可以按照统一的逻辑进行删除 在返回的时候，dummyHead.next才是头部节点
     */
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
