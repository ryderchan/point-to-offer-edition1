package offer.chapter2;

import offer.structure.ListNode;

import java.util.Stack;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class P51_PrintListReversingly {

    //inerative method(do not change ListNode)
    public static void printListReversinglyIteratively(final ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().val);
            System.out.print('\t');
        }
    }

    //recursive method(do not change ListNode)
    public static void printListReversinglyRecursively(final ListNode head){
        if(head!=null){
            printListReversinglyIteratively(head.next);
            System.out.print(head.val);
            System.out.print('\t');
        }
    }

    //reversed method(change ListNode)
    public static void printListReversinglyReversed(ListNode head) {
        if(head!=null && head.next!=null){
            ListNode prev = null;
            ListNode cur = head;
            ListNode temp = null;
            while(cur!=null){
                temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            head = prev;
        }
        while(head!=null){
            System.out.print(head.val);
            System.out.print('\t');
            head = head.next;
        }

    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printListReversinglyIteratively(head);
        System.out.println();
        printListReversinglyRecursively(head);
        System.out.println();
        printListReversinglyReversed(head);
    }
}
