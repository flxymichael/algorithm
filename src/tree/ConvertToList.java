package tree;

import java.util.Stack;

/**
 * 二叉搜素树转化为双向链表
 */
public class ConvertToList {
    public TreeNode Convert(TreeNode root) {
                if (root==null)return null;

                Stack<TreeNode> stack = new Stack<>();
                TreeNode pre = null;
                TreeNode head = null;

                while (root!=null||!stack.isEmpty()){

                    while (root!=null){
                        stack.push(root);
                        root=root.left;
                    }

                    TreeNode pop = stack.pop();
                    if (pre==null){
                        head=pop;
                    }else {
                        pre.right=pop;
                        pop.left=pre;
                    }
                    pre=pop;

                    root=pop.right;
                }




                return head;
    }
}
