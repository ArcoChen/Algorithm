package org.example.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.example.TreeNode;

/**
 * leetcode 102 层序遍历
 *
 * @author huangjiachang
 * @date 2023/7/12
 */
public class LevelTraversal {
    /**
     *  二叉树的层序遍历
     *
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
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
     * 需要借用一个辅助数据结构即队列来实现，队列先进先出，符合一层一层遍历的逻辑，而用栈先进后出适合模拟深度优先遍历也就是递归的逻辑
     * <p>
     * 1. 递归法 2. 迭代法
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

        List<List<Integer>> list = levelTraversal1(root);
        for (List<Integer> var : list) {
            System.out.println(var);
        }
    }

    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelTraversal(root,0,list);
        return list;
    }

    public static void levelTraversal(TreeNode root, int level,
        List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        level++;

        if(list.size()< level){
            List<Integer> item = new ArrayList<>();
            list.add(item);
        }
        list.get(level -1).add(root.getVal());
        levelTraversal(root.getLeft(),level,list);
        levelTraversal(root.getRight(),level,list);
    }

    /**
     * 迭代法
     */
    public static List<List<Integer>> levelTraversal1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                level.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                size--;
            }
            list.add(level);
        }
        return list;
    }
}
