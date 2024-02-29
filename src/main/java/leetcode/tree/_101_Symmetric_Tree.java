package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

//https://leetcode.com/problems/symmetric-tree/description/
public class _101_Symmetric_Tree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(3, null, null)));

        System.out.println(Objects.equals(null, "asd"));
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Deque<TreeNode> queueL = new LinkedList<>();
        Deque<TreeNode> queueR = new LinkedList<>();

        queueL.offerLast(root.left);
        queueR.offerLast(root.right);

        while (queueR.size() != 0 && queueL.size() != 0) {
            var curL = queueL.pollFirst();
            var curR = queueR.pollFirst();

            if (curR == null || curL == null) {
                return false;
            }

            if (curR.val != curL.val) {
                return false;
            }

            queueL.offerLast(curL.right);
            queueL.offerLast(curL.left);

            queueR.offerLast(curL.left);
            queueR.offerLast(curL.right);
        }
        return true;
    }

    public static void helper(TreeNode right, TreeNode left) {


    }
}
