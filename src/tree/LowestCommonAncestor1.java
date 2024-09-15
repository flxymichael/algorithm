package tree;

/**
 * 两个节点的最低位的公共祖先（普通二叉树）
 */
public class LowestCommonAncestor1 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if (root==null)return -1;
        int current=root.val;
        if (current==o1||current==o2)return current;

        int left = lowestCommonAncestor(root.left,o1,o2);
        int right = lowestCommonAncestor(root.right, o1, o2);

        if (left!=-1&&right!=-1){
            return current;
        }
        return left==-1?right:left;
    }
}
