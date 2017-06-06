package offer.chapter3;

import offer.structure.ListNode;

/**
 * Created by ryder on 2017/5/6.
 *
 */
public class P99_DeleteNodeInList {
    // time:o(1),need to guarantee the node is in the List
    // delete middle node:copy;
    // delete head node:change head node
    // delete tail node:traversal
    // java是值传递的，内部的head=head.next改动的局部变量head，所以如果不返回head，将不起作用。
    public static ListNode deleteNode(ListNode head,ListNode nodeToBeDeleted){
        if(head==null || nodeToBeDeleted==null)
            return null;
        if(nodeToBeDeleted == head){
            head = head.next;
            return head;
        }
        else if(nodeToBeDeleted.next == null){
            ListNode cur = head.next,prev=head;
            while(cur!=nodeToBeDeleted) {
                cur = cur.next;
                prev = prev.next;
            }
            prev.next = null;
            return head;
        }
        else {
            nodeToBeDeleted.val = nodeToBeDeleted.next.val;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
            return head;
        }
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = deleteNode(node1,node1);
        for(ListNode node=head;node!=null;node = node.next)
            System.out.println(node.val);
    }
}
