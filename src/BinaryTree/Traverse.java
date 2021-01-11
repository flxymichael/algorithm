package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traverse {
    public static void main(String[] args) {
        /**
         * 先序：中-左-右
         * 中序：左-中-右
         * 后序：左-右-中
         */
        System.out.println("**************************先序遍历**************************");
        System.out.print("递归先序遍历    :");
        RecursivePreOrder(InitTree.init());
        System.out.println();

        System.out.print("非递归先序遍历  :");
        nonRecursivePreOrder(InitTree.init());
        System.out.println();

        System.out.print("非递归先序遍历02:");
        nonRecursivePreOrder02(InitTree.init());
        System.out.println();

        System.out.println("**************************中序遍历**************************");
        System.out.print("递归中序遍历    :");
        RecursiveInOrder(InitTree.init());
        System.out.println();

        System.out.print("非递归中序遍历  :");
        nonRecursiveInOrder(InitTree.init());
        System.out.println();

        System.out.print("非递归中序遍历02:");
        nonRecursiveInOrder02(InitTree.init());
        System.out.println();

        System.out.println("**************************后序遍历**************************");
        System.out.print("递归后序遍历    :");
        RecursivePostOrder(InitTree.init());
        System.out.println();

        System.out.print("非递归后序遍历  :");
        nonRecursivePostOrder(InitTree.init());
        System.out.println();

        System.out.println("**************************层次遍历**************************");
        System.out.print("不分层         :");
        levelTraverse(InitTree.init());
        System.out.println();


        System.out.println("分层           :");
        levelTraverse02(InitTree.init());
        System.out.println();


        System.out.println("之字形分层       :");
        levelTraverse03(InitTree.init());
        System.out.println();



    }

    public static void visitNode(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val + "  ");
    }

    public static void printList(List<TreeNode> list){
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i).val+"  ");
        }
    }

    /**
     * 二叉树的递归遍历
     * 每个节点都访问一次，时间复杂度：O（n）
     * 递归的本质是系统帮我们建立了栈结构，空间复杂度：O（n）
     */
    //递归遍历：先序
    public static void RecursivePreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        RecursivePreOrder(root.left);
        RecursivePreOrder(root.right);
    }

    //递归遍历：中序
    public static void RecursiveInOrder(TreeNode root) {
        if (root == null) return;
        RecursiveInOrder(root.left);
        System.out.print(root.val + "  ");
        RecursiveInOrder(root.right);
    }

    //递归遍历：后序
    public static void RecursivePostOrder(TreeNode root) {
        if (root == null) return;
        RecursivePostOrder(root.left);
        RecursivePostOrder(root.right);
        System.out.print(root.val + "  ");
    }

    /**
     * 二叉树的非递归遍历（必须要用辅助栈）
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */


    //非递归遍历：先序遍历01
    public static void nonRecursivePreOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + "  ");
            if (treeNode.right != null) stack.push(treeNode.right);
            if (treeNode.left != null) stack.push(treeNode.left);
        }
    }

    //非递归遍历：先序遍历02
    public static void nonRecursivePreOrder02(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                System.out.print(root.val + "  ");
                stack.push(root);
                root = root.left;
            }
            {
                root = stack.pop().right;
            }
        }

    }


    //中序遍历的思想是：
    //
    //若节点还有左子树，就要先把左子树访问完
    //没有左子树可访问时，访问该节点，并尝试访问右子树
    //非递归遍历：中序
    public static void nonRecursiveInOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                while (!stack.empty() && root.right == null) {
                    Traverse.visitNode(root);
                    root = stack.pop();
                }
                Traverse.visitNode(root);
                root = root.right;

            }
        }

    }

    //非递归遍历：中序02
    public static void nonRecursiveInOrder02(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                visitNode(root);
                root = root.right;
            }
        }
    }

    //后序遍历
    //主要思想是：
    //尝试按顺序访问该节点的左右子树
    //当左右子树都访问完毕时，才可以访问该节点
    //依次将根节点、右孩子、左孩子入栈，以保证访问次序
    //如果当前节点是上次访问节点的父节点，则说明子树访问完成，可以访问当前节点了。
    public static void nonRecursivePostOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisited = root;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if ((node.left == null && node.right == null) ||//叶子结点
                    (node.left == lastVisited || node.right == lastVisited)) {//已经访问过，入栈顺序保证了访问顺序
                visitNode(node);
                lastVisited = node;
            } else {
                //只有叶子节点和  已经访问过所有子节点的 节点 可以访问
                //剩下的按顺序入栈即可
                stack.push(node);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

    }

    /**
     * 层次遍历
     * 使用队列
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */

    //不分层
    public static void levelTraverse(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {

            TreeNode node = list.remove(0);
            visitNode(node);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);

        }
    }

    //分层
    public static void levelTraverse02(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            while (size>0){//一层
                TreeNode node = list.remove(0);
                visitNode(node);
                size--;
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            System.out.println();//换层
        }
    }

    //分层,之字型
    public static void levelTraverse03(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        int level =1;
        ArrayList<ArrayList<TreeNode>> arrayLists = new ArrayList<>();
        while (list.size() > 0) {
            int size = list.size();
            while (size>0){//一层
                arrayLists.add(new ArrayList<>());
                TreeNode node = list.remove(0);
                arrayLists.get(level-1).add(node);
                size--;
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            if (level%2==1){
                printList(arrayLists.get(level-1));
                System.out.println();
            }else {
                Collections.reverse(arrayLists.get(level-1));
                printList(arrayLists.get(level-1));
                System.out.println();
            }
            level++;
        }
    }

    /**
     * Morris遍历
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
}
