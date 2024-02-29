package leetcode.tree;


//https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=daily-question&envId=2024-02-27
public class _543_Diameter_of_Binary_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3, null, null));

        System.out.println(diameterOfBinaryTree(treeNode));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int [] diameter = new int[]{0};
        height(root, diameter);
        return  diameter[0];
    }

    public static int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left, diameter);
        int r = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], l + r);

        return Math.max(l, r) + 1;
    }
}
