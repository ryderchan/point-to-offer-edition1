package offer.chapter5;

import offer.structure.TreeNode;

/**
 * Created by ryder on 2017/5/31.
 *
 */
public class P209_BalancedBinaryTree {
    //遍历每个节点左右子树的深度来判断，有重复遍历情况
    public static boolean isBalanced(TreeNode node){
        if(node==null)
            return true;
        int left = P207_TreeDepth.treeDepth(node.left);
        int right = P207_TreeDepth.treeDepth(node.right);
        if(Math.abs(left-right)>1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }
    //后序遍历，从下到上判断，一次遍历，无重复。
    public static boolean isBalanced1(TreeNode node){
        int[] depth = {0};
        return isBalanced1Core(node,depth);
    }
    public static boolean isBalanced1Core(TreeNode node,int[] depth){
        if(node==null){
            depth[0] = 0;
            return true;
        }
        int[] leftDepth=new int[1];
        int[] rightDepth=new int[1];
        if(isBalanced1Core(node.left,leftDepth) && isBalanced1Core(node.right,rightDepth)){
            depth[0] = Math.max(leftDepth[0],rightDepth[0])+1;
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
        System.out.println(isBalanced(node1));
        System.out.println(isBalanced1(node1));
    }
}
