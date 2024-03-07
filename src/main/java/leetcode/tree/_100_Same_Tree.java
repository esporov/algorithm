package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/same-tree/description/?envType=daily-question&envId=2024-02-27
public class _100_Same_Tree {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));
        TreeNode treeNode2 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

//        System.out.println(isSameTree(treeNode1, treeNode2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offerLast(p);
        deque.offerLast(q);

        while (deque.size() != 0) {
            var currentP = deque.pollFirst();
            var currentQ = deque.pollFirst();

            if (currentP == null && currentQ == null) {
                continue;
            } else if (currentP == null || currentQ == null) {
                return false;
            }

            if (currentP.val != currentQ.val) {
                return false;
            }

            deque.offerLast(currentP.left);
            deque.offerLast(currentQ.left);

            deque.offerLast(currentP.right);
            deque.offerLast(currentQ.right);
        }
        return true;
    }

    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }
}
