package offer.chapter2;

import offer.structure.TreeNode;
import java.util.List;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class P55_ConstructBinaryTree {
    public static TreeNode constructBinaryTree(String preorder,String inorder){
        if(preorder.length()==0 || inorder.length()==0 || preorder.length()!=inorder.length())
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(preorder.charAt(0)+""));
        int inorderIndex = inorder.indexOf(preorder.charAt(0));
        int leftLen = inorderIndex;
        root.left = constructBinaryTree(preorder.substring(1,1+leftLen),inorder.substring(0,inorderIndex));
        root.right = constructBinaryTree(preorder.substring(1+leftLen),inorder.substring(inorderIndex+1));
        return root;
    }
    public static void main(String[] args){
        String preorder = "12473568";
        String inorder = "47215386";
        TreeNode root = constructBinaryTree(preorder,inorder);

        List<Integer> list_preorderRecursively = P54_TraversalOfBinaryTree.preorderRecursively(root);
        System.out.print("preorderRecursively: "+'\t');
        System.out.println(list_preorderRecursively.toString());
        List<Integer> list_inorderRecursively = P54_TraversalOfBinaryTree.inorderRecursively(root);
        System.out.print("inorderRecursively: "+'\t');
        System.out.println(list_inorderRecursively.toString());

    }

}
