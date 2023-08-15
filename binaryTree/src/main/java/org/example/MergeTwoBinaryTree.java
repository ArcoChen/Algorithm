package org.example;

import java.util.List;
import java.util.Stack;

/**
 * leetcode 617 合并二叉树
 *
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/"></a>
 *
 * @author huangjiachang
 * @date 2023/8/15
 */
public class MergeTwoBinaryTree {
    /**
     * 给你两棵二叉树： root1 和 root2 。
     *
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     *
     * 返回合并后的二叉树。
     *
     * 注意: 合并过程必须从两个树的根节点开始。
     *
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     *
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
     */

    /**
     * 思考
     * <p>
     * 同时遍历两棵树
     */

    public static void main(String[] args) {
        TreeNode left = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.setLeft(node1);
        node3.setRight(node2);
        left.setLeft(node3);
        left.setRight(node4);

        TreeNode right = new TreeNode(5);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        right1.setLeft(right2);
        right.setLeft(right1);

//        TreeNode node = mergeTrees(left, right);
        TreeNode node = mergeTrees1(left, right);
        System.out.println("");

    }

    /**
     * 递归法
     *
     * @param root1 root1
     * @param root2 root2
     * @return 合并后的树
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 迭代法
     *
     * @param root1 root1
     * @param root2 root2
     * @return 合并后的树
     */
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            node1.val += node2.val;

            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }

            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }
}
