package offer.chapter4;

import offer.structure.TreeNode;

/**
 * Created by ryder on 2017/5/13.
 * 二叉搜索树与双向链表
 * 将二叉搜索树改为双向链表，树的left指向prev节点，树的right指向post节点
 * 左右支转换完之后要与根节点组合，所以左右支要返回自己的最小点与最大点两个节点，返回值使用数组
 */
public class P151_ConvertBinarySearchTree {
    public static TreeNode convert(TreeNode root){
        TreeNode[] headAndTail = convertBinarySearchTreeToDoubleLinkedList(root);
        return headAndTail[0]; //return head
    }
    public static TreeNode[] convertBinarySearchTreeToDoubleLinkedList(TreeNode node){
        TreeNode[] ret = new TreeNode[]{null,null};
        if(node==null)
            return ret;
        ret[0] = node;
        ret[1] = node;
        if(node.left!=null) {
            TreeNode[] temp1 = convertBinarySearchTreeToDoubleLinkedList(node.left);
            ret[0] = temp1[0];
            node.left = temp1[1];
            temp1[1].right = node;
        }
        if(node.right!=null) {
            TreeNode[] temp2 = convertBinarySearchTreeToDoubleLinkedList(node.right);
            ret[1] = temp2[1];
            node.right = temp2[0];
            temp2[0].left = node;
        }
        return ret;
    }


    public static void main(String[] args){
        //            10
        //          /   \
        //        6       14
        //      /   \    /  \
        //     4     8  12   16
        // converted: 4-6-8-10-12-14-16
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println("preorder:"+root);
        TreeNode newRoot = convert(root);
        System.out.println("converted:"+newRoot.leftToRight());
    }
}
