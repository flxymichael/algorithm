package tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    /**
     * 递归实现
     * @param root
     * @return
     */
    public int[] it(TreeNode root){
        if (root==null)return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public void inorder(TreeNode node, ArrayList<Integer> list){
        if (node==null)return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);

    }

    /**
     * 栈实现
     * @param root
     * @return
     */
    public int[] it1(TreeNode root){
        if (root==null)return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null||!stack.isEmpty()){
            /**
             * 最左节点
             */
            while (root!=null){
                stack.push(root);
                root=root.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);

            root=pop.right;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
