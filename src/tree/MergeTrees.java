package tree;

/**
 * 合并成二叉树。
 * 合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替
 */
public class MergeTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1==null)return t2;
        if (t2==null)return t1;
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left=mergeTrees(t1.left,t2.left);
        head.right=mergeTrees(t1.right,t2.right);
        return  head;
    }
}
