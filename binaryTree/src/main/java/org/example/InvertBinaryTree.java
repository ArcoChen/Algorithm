package org.example;

import java.util.List;
import java.util.Stack;

/**
 * leetcode 226  翻转二叉树
 *
 * <a href="https://leetcode.cn/problems/invert-binary-tree/"></a>
 *
 * @author huangjiachang
 * @date 2023/7/17
 */
public class InvertBinaryTree {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     */

    /**
     * 思考
     * <p>
     * 深度优先遍历，前序遍历或者后续遍历，每个节点的左右两个节点相互交换，最终实现整棵树的翻转 可通过递归或者迭代的方式实现
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

//        TreeNode invert = invertTreeDFS(root);
        TreeNode invert = invertTreeBFS(root);
        System.out.println(1);
    }

    /**
     * 递归法
     */
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTreeDFS(root.left);
        invertTreeDFS(root.right);
        swap(root);
        return root;
    }

    public static void swap(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    /**
     * 迭代法
     */
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            swap(current);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return root;
    }
}
