package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 判断是否是二叉搜索树
 */
public class IsValidBST {   
    public boolean isValidBST (TreeNode root) {
        if (root==null)return true;

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode pre  = null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }

            TreeNode current = stack.pop();
            if (pre!=null&&pre.val>current.val)return false
            root=current.right;
            pre=current;
        }
        return true;
    }
}
