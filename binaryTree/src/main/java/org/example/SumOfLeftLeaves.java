package org.example;

import java.util.List;
import java.util.Stack;

/**
 * leetcode 404 左叶子之和
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/"> </a>
 *
 * @author huangjiachang
 * @date 2023/8/14
 */
public class SumOfLeftLeaves {
    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     *
     * 输入: root = [3,9,20,null,null,15,7]
     * 输出: 24
     * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * 输入: root = [1]
     * 输出: 0
     */

    /**
     * 思考
     * <p>
     * 判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子
     * if (root.left != null && root.left.left == null && root.left.right == null)
     * <p>
     * 1. 后序遍历（左右中），通过递归函数的返回值来累加求取左叶子数值之和
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.setLeft(node1);
        node3.setRight(node2);
        node5.setLeft(node4);
        root.setLeft(node3);
        root.setRight(node5);

        System.out.println(sumOfLeftLeaves1(root));
    }

    /**
     * 递归
     *
     * @param root root
     * @return 左叶子节点之和
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左
        int leftValue = sumOfLeftLeaves(root.left);
        // 右
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }

        // 中
        return midValue + leftValue + rightValue;
    }

    /**
     * 迭代法
     *
     * @param root root
     * @return 左叶子节点之和
     */
    public static int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
