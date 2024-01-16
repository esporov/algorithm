package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _104_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode tree =
                new TreeNode(3,
                        new TreeNode(9, null, null),
                        new TreeNode(20,
                                new TreeNode(15, null, null),
                                new TreeNode(7, null, null)));
        maxDepthRec(tree);
    }
    public static int maxDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthRec(root.left);
        int right = maxDepthRec(root.right);
        return Math.max(left,right) + 1;
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode current = root;
        queue.offerLast(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                level++;
                current = queue.pollFirst();
                if (current.left != null) {
                    queue.offerLast(current.left);
                }
                if (current.right != null) {
                    queue.offerLast(current.right);
                }
            }
        }
        return level;
    }
}
