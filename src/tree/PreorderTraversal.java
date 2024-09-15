package tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public int[] pt(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root,list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public void preorder(TreeNode node, ArrayList<Integer> list){
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }

    /**
     * 栈方法
     */
    public int[] pt1(TreeNode root){
        if (root==null)
            return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode pop = s.pop();
            list.add(pop.val);
            if (pop.right!=null){
                s.push(pop.right);
            }
            if (pop.left!=null){
                s.push(pop.left);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }

}
