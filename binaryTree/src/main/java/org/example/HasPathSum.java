package org.example;

import java.util.Stack;

/**
 * leetcode 112 路径总和
 *
 * <a href="https://leetcode.cn/problems/path-sum/"></a>
 *
 * @author huangjiachang
 * @date 2023/8/15
 */
public class HasPathSum {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在
     * 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 叶子节点 是指没有子节点的节点
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     * 解释：树中存在两条根节点到叶子节点的路径：
     * (1 --> 2): 和为 3
     * (1 --> 3): 和为 4
     * 不存在 sum = 5 的根节点到叶子节点的路径。
     *
     * 输入：root = [], targetSum = 0
     * 输出：false
     * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     */

    /**
     * 思考
     * <p>
     * 可以用递归或者迭代的方式来解题
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

        boolean result = hasPathSum(root, 10);
//        boolean result = hasPathSum1(root, 10);
        System.out.println(result);
    }

    /**
     * 递归
     *
     * @param root      root
     * @param targetSum 目标值
     * @return boolean
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {
                return true;
            }
        }

        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {
                return true;
            }
        }
        return false;
    }

    /**
     * 迭代法
     *
     * @param root      root
     * @param targetSum 目标值
     * @return boolean
     */
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<Integer>();

        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int sum = sumStack.pop();

            // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
            if (node.left == null && node.right == null && targetSum == sum) {
                return true;
            }

            // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
            if (node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(sum + node.right.val);
            }

            // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(sum + node.left.val);
            }
        }

        return false;
    }
}
