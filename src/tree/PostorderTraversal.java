package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    /**
     * 递归
     * @param root
     * @return
     */
    public int[] Pt(TreeNode root){
        if (root==null)return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root,list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public void postorder(TreeNode node, ArrayList<Integer> list){
        if (node==null)return;
        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);

    }
    /**
     * 栈
     */
    public int[] Pt1(TreeNode root){
        if (root==null)return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root!=null||!stack.isEmpty()){
            //到最左
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //弹出栈顶
            TreeNode node = stack.pop();
            //如果该节点无右孩子，或右孩子已经被访问过
            if (node.right==null||node.right==pre){
                //访问该节点
                list.add(node.val);

                pre=node;
            }else {
                //先不访问，等访问了右孩子之后在啊回来访问
                stack.push(node);
                //去右孩子
                root=node.right;
            }


        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
