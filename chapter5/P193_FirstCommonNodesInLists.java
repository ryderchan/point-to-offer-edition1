package offer.chapter5;

import offer.structure.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * Created by ryder on 2017/5/31.
 */
public class P193_FirstCommonNodesInLists {
    //使用两个栈完成
    public static ListNode findFirstCommonNode(ListNode node1,ListNode node2){
        if(node1==null || node2==null)
            return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (node1!=null){
            stack1.push(node1);
            node1 = node1.next;
        }
        while (node2!=null){
            stack2.push(node2);
            node2 = node2.next;
        }
        ListNode result = null;
        while(stack1.peek()==stack2.peek()){
            result = stack1.pop();
            stack2.pop();
        }
        return result;
    }
    //先遍历，获取两个链表的长度，然后长的先前进长度之差个节点
    public static ListNode findFirstCommonNode1(ListNode node1,ListNode node2){
        if(node1==null || node2==null)
            return null;
        int size1=1,size2=1;
        for(ListNode temp = node1;temp!=null;temp=temp.next)
            size1++;
        for(ListNode temp = node2;temp!=null;temp=temp.next)
            size2++;
        if(size1>size2){
            for(int step = size1-size2;step>0;step--)
                node1 = node1.next;
        }
        else{
            for(int step = size2-size1;step>0;step--)
                node2 = node2.next;
        }
        while(node1!=null && node2!=null && node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode firstCommonNode = findFirstCommonNode(node1,node4);
        System.out.println(firstCommonNode.val);

        ListNode firstCommonNode1 = findFirstCommonNode1(node1,node4);
        System.out.println(firstCommonNode1.val);
    }
}
