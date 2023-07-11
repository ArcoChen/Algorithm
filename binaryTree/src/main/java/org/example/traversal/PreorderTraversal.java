package org.example.traversal;

import java.util.ArrayList;
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

}
