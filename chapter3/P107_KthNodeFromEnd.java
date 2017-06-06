package offer.chapter3;

import offer.structure.ListNode;

/**
 * Created by ryder on 2017/5/7.
 *
 */
public class P107_KthNodeFromEnd {
    //返回倒数第k个结点
    //类似题目：链表的中间节点（快慢指针），单向链表是否成环（快慢指针）
    //扩展：如果有环，求环的入口点（http://blog.sina.com.cn/s/blog_6a0e04380101a9o2.html）
    public static ListNode kthNodeFromEnd(ListNode head,int k){
        if(head==null || k<=0)
            return null;
        ListNode aheadNode = head,behindNode=head;
        for(int i=0;i<k;i++){
            if(aheadNode!=null)
                aheadNode = aheadNode.next;
            else
                return null;
        }
        while(aheadNode!=null){
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;

    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next =  new ListNode(2);
        head.next.next =  new ListNode(3);
        System.out.println(kthNodeFromEnd(null,0));
        System.out.println(kthNodeFromEnd(head,0));
        System.out.println(kthNodeFromEnd(head,9));
        System.out.println(kthNodeFromEnd(head,3).val);
    }
}
