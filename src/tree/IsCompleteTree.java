package tree;

/**
 * 层次遍历：使用队列来进行层次遍历，这样我们可以按照从左到右的顺序访问树中的每个节点。
 */

/**
 * 遇到空节点：在层次遍历过程中，如果我们遇到了一个空节点，
 * 那么从这个位置开始到队列中的所有后续节点都应该是空的（即队列中的后续元素应该全部是null），
 * 因为完全二叉树中不应该有任何在空节点之后的非空节点。
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断条件：我们可以设置一个标记位hasEmpty，初始化为false。
 * 在遍历过程中，当我们第一次遇到空节点时，将其设置为true。之后，如果我们再次遇到非空节点，则返回false，
 * 因为这意味着树不是完全二叉树。如果遍历完整个树且hasEmpty始终为false或之后始终保持为true
 * （即没有非空节点出现在空节点之后），则树是完全二叉树。
 */
public class IsCompleteTree {
    public boolean isCompleteTree (TreeNode root) {
        if (root==null)return true;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        Boolean hasEmpty  = false;

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current==null){
                hasEmpty=true;
                continue;
            }else {
                if (hasEmpty){
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }


        }
        return true;
    }
}
