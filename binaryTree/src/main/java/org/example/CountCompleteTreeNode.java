package org.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 222 完全二叉树的节点个数
 *
 *
 *
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/"></a>
 *
 * @author huangjiachang
 * @date 2023/7/24
 */
public class CountCompleteTreeNode {
    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，
     * 除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 输入：root = [1,2,3,4,5,6]
     * 输出：6
     *
     * 输入：root = []
     * 输出：0
     *
     * 输入：root = [1]
     * 输出：1
     */

    /**
     * 思考
     * <p>
     * 1. 通过遍历的方式，时间复杂度为O(n)
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

        int count = countNodes1(root);
        System.out.println("树中元素个数：" + count);
    }

    /**
     * 递归
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                count++;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return count;
    }

    /**
     * 针对完全二叉树的解法
     *
     * @param root
     * @return
     */
    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;

        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        // 如果左节点的深度和右节点的深度一样，则说明树是可以满二叉树，树的总结点数为：2^k - 1;
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }

        // 如果左节点和右节点深度不一样，则用递归计算
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
