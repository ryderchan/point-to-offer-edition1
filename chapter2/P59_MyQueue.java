package offer.chapter2;

import offer.structure.ListNode;

import java.util.Stack;

/**
 * Created by ryder on 2017/5/3.
 *
 * create a queue class with the help of two Stack.
 */
public class P59_MyQueue {
    public static class MyQueue<T>{
        //stack1 is used to offer ,stack2 is used to poll.
        private Stack<T> stack1=new Stack<>();
        private Stack<T> stack2=new Stack<>();
        public boolean isEmpty(){
            return stack1.isEmpty()&&stack2.isEmpty();
        }
        public void appendTail(T node){
            stack1.push(node);
        }
        public T deleteHead(){
            if(this.isEmpty()){
                return null;
            }
            if(stack2.isEmpty()){
                while(stack1.size()>0){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
