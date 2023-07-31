package org.example;

import java.util.Stack;

/**
 * leetcode 110 平衡二叉树
 *
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/"></a>
 *
 * @author huangjiachang
 * @date 2023/7/24
 */
public class BalancedBinaryTree {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     *
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     *
     * 输入：root = []
     * 输出：true
     */

    /**
     * 思考
     * <p>
     * 概念： 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数。 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。
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

        System.out.println(isBalanced(root));
    }

    /**
     * 递归法
     */
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced1(TreeNode node) {
        if (node == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 输出
                if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                node = null;// 当前结点下，没有要遍历的结点了
            } else {
                node = inNode.right;// 右结点还没遍历，遍历右结点
            }

        }
        return true;
    }

    /**
     * 求结点的高度
     */
    public int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = root.left != null ? root.left.val : 0;
        int rightHeight = root.right != null ? root.right.val : 0;
        int height = Math.max(leftHeight, rightHeight) + 1;
        root.val = height;// 用TreeNode.val来保存当前结点的高度
        return height;
    }
}
