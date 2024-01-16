package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2385_Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    public static void main(String[] args) {
        TreeNode tree =
                new TreeNode(1,
                        new TreeNode(5, null,
                                new TreeNode(4,
                                        new TreeNode(9, null, null),
                                        new TreeNode(2, null, null))),
                        new TreeNode(3,
                                new TreeNode(10, null, null),
                                new TreeNode(6, null, null)));
        TreeNode tree2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4,
                                                new TreeNode(5,
                                                        null,
                                                        null),
                                                null),
                                        null),
                                null),
                        null);
        System.out.println(amountOfTime(tree2, 3));
    }

    public static int amountOfTime(TreeNode root, int start) {
        int[] left = new int[2];
        int[] right = new int[2];

        if (root.left != null) {
            left = maxDepthRec(root.left, start, left, false);
        }
        if (root.right != null) {
            right = maxDepthRec(root.right, start, right, false);
        }
        if ((right[1] == 0 && left[1] == 0) || root.val == start) {
            return Math.max(left[0], right[0]);
        }
        if (right[0] == right[1] || left[0] == left[1]) {
            /*int d = left[0] + right[0] - (left[0] + right[0] - right[1] - left[1]);
            d = left[0] + right[0] - (left[0] + right[0] - right[1] - left[1]);

            int a = Math.max(left[0], right[0]);
            int b = Math.max(left[1], right[1]);
            int g = b - 1;
            int c = g >= a / 2 ? d : g;
            d = a - (a - b);

            return c >= a / 2 ? d : a - c;*/
            int a = Math.max(left[0], right[0]) + 1;
            int b = Math.max(left[1], right[1]);
            int c = b >= a/2 ? a - (a - b)  : b;
            c = a - (a -b);

            return  a - c;

        }
        if (right[1] == 0) {
            return Math.max(left[0] - left[1], right[0] + left[1]);
        }
        if (left[1] == 0) {
            return Math.max(right[0] - right[1], left[0] + right[1]);
        }
        return 0;
    }

    public static int[] maxDepthRec(TreeNode root, int start, int[] res, boolean flag) {
        if (root == null) {

//            res[0] = 0;
            return new int[]{0, res[1]};
        }
        int[] left = maxDepthRec(root.left, start, res, flag);
        int[] right = maxDepthRec(root.right, start, res, flag);
        if (root.val != start && !flag) {
            res[1] = Math.max(left[0], right[0]);
        }
        if (root.val == start) {
            flag = true;
        }
        int r = Math.max(left[0], right[0]) + 1;
//        res[0] = r;
        return new int[]{r, res[1]};
    }
}
