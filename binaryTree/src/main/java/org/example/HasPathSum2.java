package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huangjiachang
 * @date 2023/8/15
 */
public class HasPathSum2 {
    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * <p>
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * <p>
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
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

        List<List<Integer>> results = pathSum(root, 10);
        results.forEach(result -> {
            result.forEach(System.out::println);
            System.out.println("=====");
        });

    }

    /**
     * 递归 + 回溯
     *
     * @param root      root
     * @param targetSum 目标值
     * @return 结果集
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> paths = new ArrayList<>();
        preorderDFS(root, result, targetSum, paths);
        return result;
    }

    /**
     * 递归 + 回溯
     *
     * @param root      root
     * @param result    结果集
     * @param targetSum 目标值
     * @param paths     路径集
     */
    public static void preorderDFS(TreeNode root, List<List<Integer>> result, int targetSum, List<Integer> paths) {
        paths.add(root.val);

        // 叶子节点处理
        if (root.left == null && root.right == null) {
            // 找到了和为targetSum的路径
            if (targetSum == root.val) {
                result.add(new ArrayList<>(paths));
            } else {
                return;
            }
        }

        if (root.left != null) {
            preorderDFS(root.left, result, targetSum - root.val, paths);
            // 回溯
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            preorderDFS(root.right, result, targetSum - root.val, paths);
            // 回溯
            paths.remove(paths.size() - 1);
        }
    }
}
