package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 116 填充每个节点的下一个右侧节点指针
 *
 * @author huangjiachang
 * @date 2023/7/13
 */
public class PopulatingNextRightPointers {

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * <p>
     * struct Node { int val; Node *left; Node *right; Node *next; }
     * <p>
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL
     * <p>
     * 输入：root = [1,2,3,4,5,6,7] 输出：[1,#,2,3,#,4,5,6,7,#] 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next
     * 指针，以指向其下一个右侧节点，如图 B 所示。 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     * <p>
     * 输入：root = [] 输出：[]
     */

    /**
     * 思考
     * <p>
     * 层序遍历，在单层遍历的时候记录一下本层的头部节点，然后在遍历的时候让前一个节点指向本节点就可以了
     */

    public static void main(String[] args) {
        Node root = new Node(6);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node3.left = node1;
        node3.right = node2;
        root.left = node3;
        root.right = node4;

        Node result = connect(root);
        System.out.println("1");
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            int size = queue.size();

            Node item = queue.poll();
            if (item.left != null) {
                queue.offer(item.left);
            }
            if (item.right != null) {
                queue.offer(item.right);
            }

            for (int index = 1; index < size; index++) {
                Node next = queue.poll();
                if (next.left != null) {
                    queue.offer(next.left);
                }
                if (next.right != null) {
                    queue.offer(next.right);
                }

                item.next = next;
                item = next;
            }
        }

        return root;
    }


}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


