package offer.chapter3;

import offer.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/5/10.
 *
 */
public class P143_PathInTree {
    public static List<List<Integer>> findPathMain(TreeNode root,int expectedSum){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> curPath = new LinkedList<>();
        if(root==null)
            return result;
        findPath(root,expectedSum,result,curPath,0);
        return result;
    }

    public static void findPath(final TreeNode node,final int expectedSum,List<List<Integer>> result, List<Integer> curPath,int curSum){
        curPath.add(node.val);
        curSum += node.val;
        if(node.left==null && node.right==null){
            if(curSum==expectedSum) {
                //curPath贯穿整个递归过程，随时变换，应该保存它的拷贝
                //因为curPath是List<Integer>，所以浅拷贝就可以
                result.add(new LinkedList<>(curPath));
            }
        }
        if(node.left!=null)
            findPath(node.left,expectedSum,result,curPath,curSum);
        if(node.right!=null)
            findPath(node.right,expectedSum,result,curPath,curSum);
        //返回前将当前节点从curPath中删除，curPath会用于后续调用
        //或者每次都新创建一个curPath，在它之上进行添加，以避免后面对curPath相互间的影响，见findPath1
        curPath.remove(curPath.size()-1);
    }
        public static void findPath1(final TreeNode node,final int expectedSum,List<List<Integer>> result, final List<Integer> curPath,int curSum){
        curPath.add(node.val);
        curSum += node.val;
        if(node.left==null && node.right==null){
            if(curSum==expectedSum)
                result.add(curPath);
        }
        if(node.left!=null)
            findPath(node.left,expectedSum,result,new LinkedList<>(curPath) ,curSum);
        if(node.right!=null)
            findPath(node.right,expectedSum,result,new LinkedList<>(curPath),curSum);
    }
    public static void main(String[] args){
        //            10
        //          /   \
        //        5       12
        //      /   \
        //     4     7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        List<List<Integer>> list = findPathMain(root,22);
        System.out.println(list.toString());
    }

}
