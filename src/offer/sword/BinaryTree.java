package offer.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class BinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static void main(String[] args) {



        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

//        treeNode4.left = treeNode8;
//        treeNode5.left = treeNode9;
//        treeNode6.left = treeNode10;
//
//        treeNode7.left = treeNode11;
//        treeNode7.right = treeNode12;

        BinaryTree binaryTree = new BinaryTree();
        ArrayList<ArrayList<Integer>> result = binaryTree.Printzhi(treeNode);
        for (ArrayList<Integer> arraylist : result) {
            for (int i : arraylist) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    //从上到下打印树,无需分层
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList result = new ArrayList(100);

        if (root == null) {
            return result;
        }

        ConcurrentLinkedDeque<TreeNode> queue = new ConcurrentLinkedDeque<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {

            TreeNode t = queue.remove();
            result.add(t.val);


            if (t.left != null) {
                result.add(root.left.val);
                queue.add(root.left);
            }
            if (t.right != null) {
                result.add(root.right.val);
                queue.add(root.right);
            }

        }
        return result;

    }


    //按层打印树
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);


        while (queue.size() > 0) {

            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<Integer>();

            while (size-- > 0) {
                TreeNode t = queue.pop();
                arrayList.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            result.add(arrayList);
        }
        return result;
    }

    //按之字型 打印树

    public ArrayList<ArrayList<Integer>> Printzhi(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int level = 1;

        while (queue.size() > 0) {

            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<Integer>();

            while (size-- > 0) {
                TreeNode t = queue.removeFirst();
                if (t != null) {
                    if (t.left != null) {
                        queue.add(t.left);
                    }

                    if (t.right != null) {
                        queue.add(t.right);
                    }
                    arrayList.add(t.val);
                }
            }

            if (level % 2 == 0) {
                Collections.reverse(arrayList);
            }
            result.add(arrayList);
            level++;
        }
        return result;
    }

    //是否对称树
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return sym(pRoot.left, pRoot.right);
    }

    public boolean sym(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return sym(l.left, r.right) && sym(l.right, r.left);
    }

    //和为某一值得所有路径

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }


        return result;
    }

    //二叉搜索树中第K小的值
    ////中序遍历儿茶搜索树，就是从小到大排列的结果
    int countK = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node1 = KthNode(pRoot.left, k);
            if (node1 != null) return node1;
            if (++countK == k) return pRoot;
            TreeNode node2 = KthNode(pRoot.right, k);
            if (node2 != null) return node2;

        }
        return null;
    }

    //二叉树的深度
    //01 分治法   DFS?
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int levelLeft = TreeDepth(root.left);
        int levelRight = TreeDepth(root.right);
        return Math.max(levelLeft,levelRight)+1;//啊哈
    }

    //02 层次遍历
    public int TreeDepth02(TreeNode root) {
        int level =0 ;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root==null){
            return 0;
        }
        linkedList.add(root);
        while (linkedList.size()>0){
            int flag = linkedList.size();
            while (flag-->0){
                TreeNode t= linkedList.pop();
                if (t.left!=null){
                    linkedList.add(t.left);
                }
                if (t.right!=null){
                    linkedList.add(t.right);
                }
            }
            level++;
        }
        return level;
    }

    //根据先序遍历和中序遍历重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||in.length==0){
            return null;
        }
        if (pre.length!=in.length){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0]==in[i]){
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }



}


