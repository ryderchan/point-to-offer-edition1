package offer.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
        left = null;
        right = null;
    }

    @Override
    //preorder traversal
    public String toString() {
        StringBuilder s = new StringBuilder();
        TreeNode cur = this;
        Queue<TreeNode> queue = new LinkedList<>();
        if(cur!=null)
            queue.offer(this);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            s.append(cur.val);
            s.append("  ");
            if(cur.left!=null)
                queue.offer(cur.left);
            if(cur.right!=null)
                queue.offer(cur.right);
        }
        return s.toString();
    }
    public String leftToRight(){
        TreeNode cur = this;
        StringBuilder ret = new StringBuilder();
        while(cur!=null){
            ret.append(cur.val);
            ret.append("\t");
            cur = cur.right;
        }
        return ret.toString();
    }
}
