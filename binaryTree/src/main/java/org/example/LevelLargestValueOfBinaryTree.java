package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 515 在每个树行中找最大值
 *
 * @author huangjiachang
 * @date 2023/7/13
 */
public class LevelLargestValueOfBinaryTree {
    /**
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     *
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     *
     * 输入: root = [1,2,3]
     * 输出: [1,3]
     */

    /**
     * 思考
     * <p>
     * 层序遍历 找到每一层的最大值，加入list
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

        List<Integer> list = largestValues(root);
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans = ans > node.getVal() ? ans : node.val;
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            list.add(ans);
        }
        return list;
    }
}
