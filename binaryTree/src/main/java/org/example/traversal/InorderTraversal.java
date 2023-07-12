package org.example.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.example.TreeNode;

/**
 * leetcode 94 二叉树的中序遍历
 *
 * @author huangjiachang
 * @date 2023/7/11
 */
public class InorderTraversal {

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *
     * 输入：root = []
     * 输出：[]
     *
     * 输入：root = [1]
     * 输出：[1]
     */

    /**
     * 思考
     * <p>
     * 二叉树的深度优先遍历，可以使用递归和迭代法的方式来实现
     * <p>
     * 中序遍历：左 -> 根 -> 右
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.setLeft(node1);
        node3.setRight(node2);
        root.setLeft(node3);
        root.setRight(node4);

        List<Integer> list = inorderTraversal1(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归的方式
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 左
        List<Integer> left = inorderTraversal(root.getLeft());
        list.addAll(left);
        // 根
        list.add(root.getVal());
        // 右
        List<Integer> right = inorderTraversal(root.getRight());
        list.addAll(right);

        return list;
    }

    /**
     * 迭代法 利用栈来实现
     * <p>
     * 前序遍历：左 -> 根 -> 右
     * <p>
     * 迭代法不是将所有的元素都压入栈中， 利用两层for循环，先压入左树，如果左树已经完成遍历，那么此时stack为空，在第一层for循环，再压入右树
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            root = stack.pop();
            list.add(root.getVal());
            root = root.getRight();
        }

        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            } else {
                cur = stack.pop();
                result.add(cur.getVal());
                cur = cur.getRight();
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.getRight() != null) {
                    st.push(node.getRight());  // 添加右节点（空节点不入栈）
                }
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                if (node.getLeft() != null) {
                    st.push(node.getLeft());    // 添加左节点（空节点不入栈）
                }
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.getVal()); // 加入到结果集
            }
        }
        return result;
    }
}
