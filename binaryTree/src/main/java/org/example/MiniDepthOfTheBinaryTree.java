package org.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 111 二叉树的最小深度
 *
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/"></a>
 *
 * @author huangjiachang
 * @date 2023/7/24
 */
public class MiniDepthOfTheBinaryTree {

    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     * <p>
     * 输入：root = [3,9,20,null,null,15,7] 输出：2
     * <p>
     * 输入：root = [2,null,3,null,4,null,5,null,6] 输出：5
     */

    /**
     * 思考
     *
     * 1. 递归法， 通过递归的方式，如果子节点为空，则返回总数，如果子节点不会空，则递归遍历，并且找到最小的树深度
     * 2. 迭代法，利用stack或者queue
     * @param args
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

        int depth = miniDepth1(root);
        System.out.println("树的最小深度：" + depth);
    }

    /**
     * 递归法
     */
    public static int miniDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = miniDepth(root.left);
        int right = miniDepth(root.right);
        if (root.left == null) {
            return right + 1;
        }
        if (root.right == null) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }

    public static int miniDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
