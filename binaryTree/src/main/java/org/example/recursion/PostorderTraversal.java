package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.example.TreeNode;

/**
 * leetcod 145 二叉树的后序遍历
 *
 * @author huangjiachang
 * @date 2023/7/11
 */
public class PostorderTraversal {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     * 输入：root = [1,null,2,3]
     * 输出：[3,2,1]
     *
     * 输入：root = []
     * 输出：[]
     *
     * 输入：root = [1]
     * 输出：[1]
     */

    /**
     *
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

//        List<Integer> list = postorderTraversal(root);
        List<Integer> list = postorderTraversal1(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归的方式
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 左
        List<Integer> left = postorderTraversal(root.getLeft());
        list.addAll(left);
        // 右
        List<Integer> right = postorderTraversal(root.getRight());
        list.addAll(right);
        // 根
        list.add(root.getVal());

        return list;
    }

    /**
     * 后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过
     * 因此，我们在后序遍历中，引入了一个prev来记录历史访问记录
     *
     * 当访问完一棵子树的时候，我们用prev指向该节点
     * 这样，在回溯到父节点的时候，我们可以依据prev是指向左子节点，还是右子节点，来判断父节点的访问情况
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        // 由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        // 因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            // 从栈中弹出的元素，左子树一定是访问完了的
            root = stack.pop();

            // 现在需要确定的是否有右子树，或者右子树是否访问过
            // 如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时,说明可以访问当前节点
            if (root.getRight() == null || root.getRight() == prev) {
                list.add(root.getVal());
                // 更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                prev = root;
                root = null;
            } else {
                // 如果右子树没有被访问，那么将当前节点压栈，访问右子树
                stack.push(root);
                root = root.getRight();
            }
        }
        return list;
    }
}
