package offer.chapter3;

import offer.structure.TreeNode;

/**
 * Created by ryder on 2017/5/10.
 * 判断是否为二叉搜索树的后序遍历序列
 * 前提：无相等值
 */
public class P140_SequenceOfBST {
    public static boolean verifySequenceOfBST(int[] data){
        if(data==null|| data.length==0)
            return true;
        //判断范围为[start,end]
        return isPostOrderOfBST(data,0,data.length-1);
    }
    public static boolean isPostOrderOfBST(int[] data,int start,int end){
        //空返回true,个人认为也说得通；空的二叉搜索树的遍历就是null
        if(end-start<=1)
            return true;
        int leftTreeBound = 0;
        for(;leftTreeBound<end;leftTreeBound++){
            if(data[leftTreeBound]>data[end])
                break;
        }
        int rightTreeBound = leftTreeBound;
        leftTreeBound--;
        for(;rightTreeBound<end;rightTreeBound++){
            if(data[rightTreeBound]<data[end])
                return false;
        }
        rightTreeBound--;
        return isPostOrderOfBST(data,start,leftTreeBound) && isPostOrderOfBST(data,leftTreeBound+1,rightTreeBound);
    }
    public static void main(String[] args){
        //            8
        //          /   \
        //        6       10
        //      /   \   /   \
        //     5     7  9    11
        // postorder:5,7,6,9,11,10,8
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        int[] data1 = {5,7,6,9,11,10,8};
        int[] data2 = {5,7,6,9,11,1,8};
        System.out.println(verifySequenceOfBST(null));
        System.out.println(verifySequenceOfBST(data1));
        System.out.println(verifySequenceOfBST(data2));
    }
}
