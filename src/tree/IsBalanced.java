package tree;

/**
 * 是否为平衡二叉树
 */
public class IsBalanced {

        public int depth(TreeNode node){
            if (node==null)return 0;
            int dl = depth(node.left);
            int dr = depth(node.right);
            return (dl>dr)?dl+1:dr+1;
        }
    public boolean IsBalanced_Solution (TreeNode root) {
        if (root==null)return true;
        int dl = depth(root.left);
        int dr = depth(root.right);
        if (Math.abs(dl-dr)>1)return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

}
