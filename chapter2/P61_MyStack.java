package offer.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ryder on 2017/5/3.
 */
public class P61_MyStack {
    public static class MyStack<T>{
        private Queue<T> queue1 = new LinkedList<>();
        private Queue<T> queue2 = new LinkedList<>();
        public boolean isEmpty(){
            return queue1.isEmpty()&&queue2.isEmpty();
        }
        public void appendTail(T node){
            if(queue2.isEmpty()) queue1.offer(node);
            else queue2.offer(node);
        }
        public T deleteTail(){
            if(this.isEmpty())
                return null;
            if(queue2.isEmpty()){
                while(!queue1.isEmpty()){
                    if(queue1.size()==1)
                        return queue1.poll();
                    else{
                        queue2.offer(queue1.poll());
                    }
                }
            }
            else{
                while(!queue2.isEmpty()){
                    if(queue2.size()==1)
                        return queue2.poll();
                    else{
                        queue1.offer(queue2.poll());
                    }
                }
            }
            return null;
        }
    }

    public static class MyStack1<T> {
        private Queue<T> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void appendTail(T node) {
            int size = queue.size();
            queue.offer(node);
            while(size-->0){
                queue.offer(queue.poll());
            }
        }

        public T deleteTail() {
            return queue.poll();
        }
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        stack.appendTail(1);
        stack.appendTail(2);
        stack.appendTail(3);
        System.out.println(stack.deleteTail());
        stack.appendTail(4);
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
        System.out.println(stack.deleteTail());
        System.out.println();
        MyStack1<Integer> stack1 = new MyStack1<>();
        stack1.appendTail(1);
        stack1.appendTail(2);
        stack1.appendTail(3);
        System.out.println(stack1.deleteTail());
        stack1.appendTail(4);
        System.out.println(stack1.deleteTail());
        System.out.println(stack1.deleteTail());
        System.out.println(stack1.deleteTail());
        System.out.println(stack1.deleteTail());
    }
}
