package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 根据先序和中序重建二叉树并输出右视图
 */
public class RightSideView {
    private HashMap<Integer,Integer> inOrderMap =new HashMap<>();
    public int[] solve (int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i],i);
        }
        TreeNode root=reConstructBinaryTree(preOrder,0,preOrder.length-1,0,inOrder.length-1);
        // write code here
        return getRightSideView(root);
    }
    private TreeNode reConstructBinaryTree(int[] preOrder,int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preStart]);
        Integer inNodeIndex = inOrderMap.get(node.val);

        int leftTreeSize = inNodeIndex - inStart;

        node.left=reConstructBinaryTree(preOrder,preStart+1,preStart+leftTreeSize,inStart,inNodeIndex-1);
        node.right=reConstructBinaryTree(preOrder,preStart+leftTreeSize+1,preEnd,inNodeIndex+1,inEnd);

        return node;
    }
    private int[] getRightSideView(TreeNode root){
        if (root==null)return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode>  queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
           int levelSize= queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i==levelSize-1){
                    list.add(node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
