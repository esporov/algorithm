package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/even-odd-tree/description/?envType=daily-question&envId=2024-02-29
public class _1609_Even_Odd_Tree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(3, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(2,
                        new TreeNode(7, null, null),
                        null));
        System.out.println(isEvenOddTree(treeNode));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        int prev = 0;
        int level = 0;

        queue.offerLast(root);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size != 0) {
                TreeNode curNode = queue.pollFirst();
                int curVal = curNode.val;

                if (level % 2 == 0 && (prev >= curVal || curVal % 2 == 0)) {
                    return false;
                }

                if (level % 2 != 0 && (prev <= curVal || curVal % 2 != 0)) {
                    return false;
                }

                if (curNode.left != null) {
                    queue.offerLast(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offerLast(curNode.right);
                }

                prev = curNode.val;
                size--;
            }

            level++;
            if (level % 2 == 0) {
                prev = 0;
            } else {
                prev = Integer.MAX_VALUE;
            }
        }
        return true;
    }
}
