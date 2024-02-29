package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/find-bottom-left-tree-value/?envType=daily-question&envId=2024-02-27
public class _513_Find_Bottom_Left_Tree_Value {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offerLast(root);
        while (deque.size() != 0) {
            int maxSize = deque.size();
            int curSize = maxSize;

            while (curSize != 0) {
                TreeNode current = deque.pollFirst();
                if (maxSize == curSize) {
                    max = current.val;
                }
                if (current.left != null) {
                    deque.offerLast(current.left);
                }
                if (current.right != null) {
                    deque.offerLast(current.right);
                }
                curSize--;
            }
        }
        return max;
    }
}
