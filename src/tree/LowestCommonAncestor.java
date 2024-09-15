package tree;

/**
 * 两个节点的最低位的公共祖先（二叉搜索树）
 */

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestor {

    /**
     *  直接得到从根节点到两个目标节点的路径，这样我们利用路径比较就可以找到最近公共祖先。
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root==null){return -1;}

        ArrayList<Integer> pathP = getPath(root,p);
        ArrayList<Integer> pathQ = getPath(root,q);

        int  result  = -1;
        for (int i = 0; i < pathQ.size()&&i< pathP.size(); i++) {
            if (pathP.get(i).equals(pathQ.get(i))){
                result=pathP.get(i);
            }else {
                break;
            }
        }
        return result;
    }
    public ArrayList<Integer> getPath(TreeNode node,int target){
        if(node==null){
            return new ArrayList();
        }

        ArrayList<Integer> path = new ArrayList<>();
        while (node!=null&&node.val!=target){
            path.add(node.val);
            if (node.val>target){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        if (node!=null){
            path.add(node.val);
        }

        return path;
    }

    /**
     * 利用二叉搜索树节点的大小性质进行查找，也可用递归
     */
    /**
     * step 1：首先检查空节点，空树没有公共祖先。
     * step 2：对于某个节点，比较与p、q的大小，若p、q在该节点两边说明这就是最近公共祖先。
     * step 3：如果p、q都在该节点的左边，则递归进入左子树。
     * step 4：如果p、q都在该节点的右边，则递归进入右子树。
     * @param root
     * @param p
     * @param q
     * @return
     */

    public int lowestCommonAncestor1 (TreeNode root, int p, int q) {
        if (root==null)return -1;
        while (root!=null){
            if (p<root.val&&q<root.val){
               root=root.left;
            }else if (p>root.val&&q>root.val){
                root=root.right;
            }else {
                return root.val;
            }
        }
        return -1;
    }


}
