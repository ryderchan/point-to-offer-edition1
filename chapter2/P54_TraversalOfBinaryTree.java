package offer.chapter2;

import offer.structure.TreeNode;

import java.util.*;

/**
 * Created by ryder on 2017/5/2.
 *
 * four types(seven implements)
 * preorder(recursively,iteratively)
 * inorder(recursively,iteratively)
 * postorder(recursively,iteratively)
 * and levelorder
 */
public class P54_TraversalOfBinaryTree {
    public static List<Integer> preorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.add(root.val);
            list.addAll(preorderRecursively(root.left));
            list.addAll(preorderRecursively(root.right));
        }
        return list;
    }
    public static List<Integer> inorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.addAll(inorderRecursively(root.left));
            list.add(root.val);
            list.addAll(inorderRecursively(root.right));
        }
        return list;
    }
    public static List<Integer> postorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.addAll(postorderRecursively(root.left));
            list.addAll(postorderRecursively(root.right));
            list.add(root.val);
        }
        return list;
    }
    public static List<Integer> preorderIteratively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        //the stack top is always the father node of cur
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop().right;
            }
        }
        return list;
    }
    public static List<Integer> inorderIteratively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        //the stack top is always the father node of cur
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                list.add(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        return list;
    }
    public static List<Integer> postorderIteratively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prevVisited is the node visited just before,which is used to distinguish whether
        //the the right node had visited or not(like a flag)
        TreeNode prevVisited = null;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.peek().right;
                if(cur!=null && cur!=prevVisited){
                    stack.push(cur);
                    cur = cur.left;
                }
                else{
                    prevVisited = stack.pop();
                    list.add(prevVisited.val);
                    cur = null;
                }
            }
        }
        return list;
    }
    public static List<Integer> levelorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        if(root==null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            list.add(cur.val);
            if(cur.left!=null)
                queue.offer(cur.left);
            if(cur.right!=null)
                queue.offer(cur.right);
        }
        return list;
    }
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
        List<Integer> list_preorderRecursively = preorderRecursively(root);
        System.out.print("preorderRecursively: "+'\t');
        System.out.println(list_preorderRecursively.toString());

        List<Integer> list_inorderRecursively = inorderRecursively(root);
        System.out.print("inorderRecursively: "+'\t');
        System.out.println(list_inorderRecursively.toString());

        List<Integer> list_postorderRecursively = postorderRecursively(root);
        System.out.print("postorderRecursively: "+'\t');
        System.out.println(list_postorderRecursively.toString());
        System.out.println();


        List<Integer> list_preorderIteratively = preorderIteratively(root);
        System.out.print("preorderIteratively: "+'\t');
        System.out.println(list_preorderIteratively.toString());

        List<Integer> list_inorderIteratively = inorderIteratively(root);
        System.out.print("inorderIteratively: "+'\t');
        System.out.println(list_inorderIteratively.toString());

        List<Integer> list_postorderIteratively = postorderIteratively(root);
        System.out.print("postorderIteratively: "+'\t');
        System.out.println(list_postorderIteratively.toString());
        System.out.println();


        List<Integer> list_levelorder = levelorder(root);
        System.out.print("levelorder: "+'\t');
        System.out.println(list_levelorder.toString());
    }
}
