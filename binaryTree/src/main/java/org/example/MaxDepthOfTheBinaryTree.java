package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 104 二叉树的最大深度
 *
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree"></a>
 *
 * @author huangjiachang
 * @date 2023/7/17
 */
public class MaxDepthOfTheBinaryTree {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *    返回它的最大深度 3
     */

    /**
     * 思考
     * <p>
     * 层序遍历，每遍历一层，深度加1
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

        int depth = maxDepth(root);
        System.out.println("树的最大深度：" + depth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                len--;
            }
            depth++;
        }
        return depth;
    }
}
