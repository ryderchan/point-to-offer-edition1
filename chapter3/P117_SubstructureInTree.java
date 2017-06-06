package offer.chapter3;

import offer.structure.TreeNode;

/**
 * Created by ryder on 2017/5/7.
 *
 */
public class P117_SubstructureInTree {
    //判断sub是否是root树的子结构
    //很像是字符串模式匹配的暴力解法
    //因此，针对于树结构，应该也有更优的匹配算法
    public static boolean isSubtree(TreeNode root,TreeNode sub){
        if(sub==null)
            return true;
        else if(root==null)
            return false;
        else{
            boolean result = false;
            if(root.val==sub.val)
                result = isTree1HasTree2(root,sub);
            if(!result)
                result = isSubtree(root.left,sub);
            if(!result)
                result = isSubtree(root.right,sub);
            return result;
        }
    }
    public static boolean isTree1HasTree2(TreeNode tree1,TreeNode tree2){
        if(tree2==null)
            return true;
        if(tree1==null)
            return false;
        if(tree1.val==tree2.val)
            return isTree1HasTree2(tree1.left,tree2.left) && isTree1HasTree2(tree1.right,tree2.right);
        else
            return false;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        TreeNode sub = new TreeNode(3);
        sub.left = new TreeNode(4);
        sub.right = new TreeNode(5);
        System.out.println(isSubtree(null,sub));
        System.out.println(isSubtree(root,null));
        System.out.println(isSubtree(root,sub));
    }
}
