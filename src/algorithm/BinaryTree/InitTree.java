package algorithm.BinaryTree;

/**
 *                       1
 *              2                  3
 *      4            5      6               7
 *  8             9       10            11      12
 *
 *  先序 1  2  4  8  5  9  3  6  10  7  11  12
 *  中序 8  4  2  9  5  1  10  6  3  11  7  12
 *  后序 8  4  9  5  2  10  6  11  12  7  3  1
 */

public class InitTree {

    public static TreeNode init() {
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

        treeNode4.left = treeNode8;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode10;

        treeNode7.left = treeNode11;
        treeNode7.right = treeNode12;
        return treeNode;
    }
}
