package offer.chapter3;

import offer.structure.ListNode;

/**
 * Created by ryder on 2017/5/7.
 *
 */
public class P114_MergeSortedLists {
    //递归版
    public static ListNode mergeSortedLists(ListNode head1,ListNode head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        ListNode mergedHead = null;
        if(head1.val<=head2.val){
            mergedHead = head1;
            mergedHead.next = mergeSortedLists(head1.next,head2);
        }
        else{
            mergedHead = head2;
            mergedHead.next = mergeSortedLists(head1,head2.next);
        }
        return mergedHead;
    }

    //循环迭代版
    public static ListNode mergeSortedLists2(ListNode head1,ListNode head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        ListNode node = null,newHead =null;
        if(head1.val<=head2.val){
            newHead = head1;
            node=head1;
            head1=head1.next;
        }
        else{
            newHead = head2;
            node=head2;
            head2=head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                node.next = head1;
                node=node.next;
                head1=head1.next;
            }
            else{
                node.next = head2;
                node =node.next;
                head2=head2.next;
            }
        }
        if(head1!=null){
            node.next = head1;
        }
        if(head2!=null){
            node.next = head2;
        }
        return newHead;
    }
    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next =  new ListNode(3);
        head1.next.next =  new ListNode(5);
        ListNode head2 = new ListNode(2);
        head2.next =  new ListNode(4);
        ListNode newHead = mergeSortedLists(head1,head2);
        System.out.println(newHead.toString());

        ListNode h1 = new ListNode(1);
        h1.next =  new ListNode(3);
        h1.next.next =  new ListNode(5);
        ListNode h2 = new ListNode(2);
        h2.next =  new ListNode(4);
        ListNode nd = mergeSortedLists2(h1,h2);
        System.out.println(nd.toString());


    }
}
