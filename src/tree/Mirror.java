package tree;

/**
 * 二叉树镜像
 */
public class Mirror {
    public TreeNode mirror (TreeNode root) {
        if (root==null)return null;
        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
