package offer.chapter3;

import offer.structure.ListNode;

/**
 * Created by ryder on 2017/5/7.
 *
 */
public class P112_ReverseList {
    public static ListNode reverseList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev = null,cur = head,temp=null;
        while(cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next =  new ListNode(2);
        head.next.next =  new ListNode(3);
        ListNode newHead = reverseList(head);
        System.out.println(newHead.toString());
    }
}
