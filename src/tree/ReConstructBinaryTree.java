package tree;

import java.util.HashMap;

/**
 * 根据先序和中序重建二叉树
 */
public class ReConstructBinaryTree {
    private HashMap<Integer,Integer> inOrderMap =new HashMap<>();
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] inOrder) {
        // write code here
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i],i);
        }
        return process(preOrder,0,preOrder.length-1,0,inOrder.length-1);
    }
    private TreeNode process(int[] preOrder, int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);
        int inNodeIndex = inOrderMap.get(node.val);

        int leftTreeSize = inNodeIndex-inStart;

        node.left=process(preOrder,preStart+1,preStart+leftTreeSize,inStart,inNodeIndex-1);
        node.right=process(preOrder,preStart+leftTreeSize+1,preEnd,inNodeIndex+1,inEnd);

        return node;

    }
}
