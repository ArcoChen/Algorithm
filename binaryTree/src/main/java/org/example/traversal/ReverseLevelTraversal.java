package org.example.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.example.TreeNode;

/**
 * @author huangjiachang
 * @date 2023/7/12
 */
public class ReverseLevelTraversal {
    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[15,7],[9,20],[3]]
     *
     * 输入：root = [1]
     * 输出：[[1]]
     *
     * 输入：root = []
     * 输出：[]
     */

    /**
     * 思考
     * <p>
     * 1. 解法：队列，迭代。层序遍历，再翻转数组即可。
     * 2. 解法：队列，迭代。层序遍历，插入到头部。
     *
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

        List<List<Integer>> list = reverseLevelTraversal(root);
        for (List<Integer> var : list) {
            System.out.println(var);
        }
    }

    /**
     * 迭代法，层序遍历，最后翻转list
     * @param root
     * @return
     */
    public static List<List<Integer>> reverseLevelTraversal(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            list.add(item);
        }

        // 翻转list
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * 迭代法，层序遍历，利用linkedList，每次插入头部
     *
     */
    public static List<List<Integer>> reverseLevelTraversal1(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            list.addFirst(item);
        }
        return list;
    }
}
