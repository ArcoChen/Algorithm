
/**
 * leetcode 707 设计链表(双向)
 *
 * @author huangjiachang
 * @date 2023/7/9
 */
public class DesignDoublyLinkedList {

    /**
     * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
     * <p>
     * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
     * <p>
     * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
     * <p>
     * 实现 MyLinkedList 类：
     * <p>
     * MyLinkedList() 初始化 MyLinkedList 对象。 int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 void addAtTail(int
     * val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 void addAtIndex(int index, int val) 将一个值为 val
     * 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 void
     * deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     */
    ListNode head;
    ListNode tail;
    int size;

    public DesignDoublyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size=0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode current;
        if(index + 1 <size - index){
            current = head;
            for(int i = 0; i <= index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i = 0; i< size - index; i++){
                current = current.prev;
            }
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }

        index = Math.max(0, index);
        ListNode prev,succ;
        if(index < size - index){
            prev = head;
            for(int i = 0; i < index; i++){
                prev = prev.next;
            }
            succ = prev.next;
        }else{
            succ = tail;
            for(int i =0; i < size - index; i++){
                succ = succ.prev;
            }
            prev = succ.prev;
        }

        size++;
        ListNode add = new ListNode(val);
        add.prev = prev;
        add.next = succ;
        prev.next = add;
        succ.prev = add;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }

        ListNode pre,succ;
        if(index < size - index){
            pre = head;
            for(int i = 0;i < index; i++){
                pre = pre.next;
            }
            succ = pre.next.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - index - 1; i++){
                succ = succ.prev;
            }
            pre = succ.prev.prev;
        }

        size--;
        pre.next = succ;
        succ.prev = pre;
    }

    class ListNode {

        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
