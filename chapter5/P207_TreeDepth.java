package offer.chapter5;

import offer.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ryder on 2017/5/31.
 */
public class P207_TreeDepth {
    //递归版
    public static int treeDepth(TreeNode node){
        if(node==null)
            return 0;
        else
            return 1+Math.max(treeDepth(node.left),treeDepth(node.right));
    }
    //非递归版,一般递归向非递归的转换都会增加栈或队列
    public static int treeDepth1(TreeNode node){
        if(node==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        while(!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                TreeNode temp = queue.poll();
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
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
        System.out.println(treeDepth(node1));
        System.out.println(treeDepth1(node1));
    }
}
