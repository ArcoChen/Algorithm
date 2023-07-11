package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.example.TreeNode;

/**
 * leetcode 94 二叉树的中序遍历
 *
 * @author huangjiachang
 * @date 2023/7/11
 */
public class InorderTraversal {

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *
     * 输入：root = []
     * 输出：[]
     *
     * 输入：root = [1]
     * 输出：[1]
     */

    /**
     * 思考
     * <p>
     * 二叉树的深度优先遍历，可以使用递归和迭代法的方式来实现
     * <p>
     * 中序遍历：左 -> 根 -> 右
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

        List<Integer> list = inorderTraversal1(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归的方式
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 左
        List<Integer> left = inorderTraversal(root.getLeft());
        list.addAll(left);
        // 根
        list.add(root.getVal());
        // 右
        List<Integer> right = inorderTraversal(root.getRight());
        list.addAll(right);

        return list;
    }

    /**
     * 迭代法 利用栈来实现
     * <p>
     * 前序遍历：左 -> 根 -> 右
     * <p>
     * 迭代法不是将所有的元素都压入栈中，
     * 利用两层for循环，先压入左树，如果左树已经完成遍历，那么此时stack为空，在第一层for循环，再压入右树
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            root = stack.pop();
            list.add(root.getVal());
            root= root.getRight();
        }

        return list;
    }
}
