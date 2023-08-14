package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * leetcode 257  二叉树的所有路径
 * <a href="https://leetcode.cn/problems/binary-tree-paths/"></a>
 *
 * @author huangjiachang
 * @date 2023/8/14
 */
public class BinaryTreePaths {
    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     *
     * 输入：root = [1]
     * 输出：["1"]
     */

    /**
     * 思考
     * <p>
     * 这道题目要求从根节点到叶子的路径，所以需要前序遍历，这样才方便让父节点指向孩子节点，找到对应的路径
     * 要把路径记录下来，需要回溯来回退一个路径再进入另一个路径
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

//        List<String> result = binaryTreePaths(root);
        List<String> result = binaryTreePaths1(root);
        result.forEach(System.out::println);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    /**
     * 递归 + 回溯
     *
     * @param root   root
     * @param paths  路径
     * @param result 返回结果
     */
    public static void traversal(TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                builder.append(paths.get(i));
                builder.append("->");
            }
            // 最后一个节点
            builder.append(paths.get(paths.size() - 1));
            result.add(builder.toString());
            return;
        }

        if (root.left != null) {
            traversal(root.left, paths, result);
            // 回溯
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, paths, result);
            // 回溯
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * 迭代法
     *
     * @param root root
     */
    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Object> stack = new Stack<>();
        // 节点入栈
        stack.push(root);
        // 路径入栈
        stack.push(root.val + "");

        while (!stack.isEmpty()) {
            // 路径出栈
            String path = (String) stack.pop();
            // 节点出栈
            TreeNode node = (TreeNode) stack.pop();

            // 叶子节点加入结果集
            if (node.left == null && node.right == null) {
                result.add(path);
            }

            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }

            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }

        return result;
    }
}
