package org.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 101 对称二叉树
 *
 * < a href="https://leetcode.cn/problems/symmetric-tree/"></>
 * @author huangjiachang
 * @date 2023/7/17
 */
public class SymmetricBinaryTree {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */

    /**
     * 思考
     * <p>
     * 通过递归函数的返回值来判断两个子树的内侧节点和外侧节点是否相等，只能使用后序遍历
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

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return compare(root.getLeft(), root.getRight());
    }

    /**
     * 递归法
     */
    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        // 比较外侧
        boolean outside = compare(left.getLeft(), right.getRight());
        // 比较内侧
        boolean inside = compare(left.getRight(), right.getLeft());

        return outside && inside;
    }

    /**
     * 迭代法
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
