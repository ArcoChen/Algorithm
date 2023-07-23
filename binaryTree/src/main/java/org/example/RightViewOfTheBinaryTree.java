package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 199 二叉树的右视图
 *
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/"></a>
 *
 * @author huangjiachang
 * @date 2023/7/13
 */
public class RightViewOfTheBinaryTree {
    /**
     *  给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     *  输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     *
     * 输入: [1,null,3]
     * 输出: [1,3]
     */

    /**
     * 思考
     * <p>
     * 通过层序遍历，返回每一层的最右边一个节点即可
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

        List<Integer> list = rightViewOfTheBinaryTree(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> rightViewOfTheBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                if (i == level - 1) {
                    list.add(node.getVal());
                    break;
                }
            }
        }

        return list;
    }
}
