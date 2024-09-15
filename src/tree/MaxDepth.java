package tree;

public class MaxDepth {
    public int maxDepth (TreeNode root) {
        if (root==null) return 0;
        return process(root,1);
    }
    public int process(TreeNode node,int depth){
        if (node==null)return depth-1;
        int dl =process(node.left,depth+1);
        int dr =process(node.right,depth+1);
        return Math.max(dl,dr);

    }
}
