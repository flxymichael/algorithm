package BinaryTree;

import java.util.ArrayList;

public class FindSumPath {
    // 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || root.val > target) return lists;
        dfs(root, target, lists, list);
        return lists;
    }

    public void dfs(TreeNode node, int remain, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        if (node == null) return;
        remain -= node.val;
        if (remain<0)return;
        if (node.right == null && node.left == null) {
            if (remain == 0) {
                list.add(node.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(node.val);
        dfs(node.left, remain, lists, list);
        dfs(node.right, remain, lists, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new FindSumPath().FindPath(InitTree.init(), 22);
        for (ArrayList<Integer> list : arrayLists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
