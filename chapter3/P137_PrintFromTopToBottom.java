package offer.chapter3;

import offer.structure.TreeNode;

import java.util.List;

/**
 * Created by ryder on 2017/5/10.
 * 从上到下打印二叉树
 * 见chapter2.P54_TraversalOfBinaryTree
 */
public class P137_PrintFromTopToBottom {
    public static void main(String[] args){
        //            1
        //          /   \
        //      null      2
        //              /   \
        //              3   null
        //            /   \
        //          null  null
        //pre->123  in->132   post->321  level->123
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list_levelorder = offer.chapter2.P54_TraversalOfBinaryTree.levelorder(root);
        System.out.print("levelorder: "+'\t');
        System.out.println(list_levelorder.toString());
    }
}
