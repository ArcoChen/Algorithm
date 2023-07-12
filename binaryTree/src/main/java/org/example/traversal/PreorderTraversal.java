package org.example.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.example.TreeNode;

/**
 * leetcode 144 二叉树的前序遍历
 *
 * @author huangjiachang
 * @date 2023/7/11
 */
public class PreorderTraversal {

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     *
     * 输入：root = []
     * 输出：[]
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     */

    /**
     * 思考
     * <p>
     * 二叉树的深度优先遍历，可以使用递归和迭代法的方式来实现
     * <p>
     * 前序遍历：根 -> 左 -> 右
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

        List<Integer> list = preorderTraversal1(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归的方式
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 根
        list.add(root.getVal());
        // 左
        List<Integer> left = preorderTraversal(root.getLeft());
        list.addAll(left);
        // 右
        List<Integer> right = preorderTraversal(root.getRight());
        list.addAll(right);

        return list;
    }

    /**
     * 迭代法 利用栈来实现
     * <p>
     * 前序遍历：根 -> 左 -> 右 先遍历根节点，将其加入栈中，再将根节点弹出 再将右节点加入栈中 再将左节点加入栈中
     * <p>
     * 为什么要先加右节点，再加左节点？ 因为栈是先进后出，所以，需要先讲右节点加入栈中，才能保证弹出的时候，右节点在左节点之后
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.getVal());
            // 因为栈是先进后出，所以，需要先讲右节点加入栈中，才能保证弹出的时候，右节点在左节点之后
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
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
                if (node.getLeft() != null) {
                    st.push(node.getLeft());    // 添加左节点（空节点不入栈）
                }
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

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
