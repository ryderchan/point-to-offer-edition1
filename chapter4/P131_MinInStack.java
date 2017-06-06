package offer.chapter4;

import java.util.Stack;

/**
 * Created by ryder on 2017/5/9.
 * 包含min函数的栈
 */
public class P131_MinInStack {
    //要求泛型T为可比较的，即继承自Comparable（可以使用compareTo）,这样min才有意义
    static class StackWithMin<T extends Comparable<T>> {
        private Stack<T> dataStack = new Stack<>();
        private Stack<T> minStack = new Stack<>();
        public void push(T value) {
            dataStack.push(value);
            if (minStack.isEmpty())
                minStack.push(value);
            else {
                minStack.push(value.compareTo(minStack.peek()) <= 0 ? value : minStack.peek());
            }
        }
        public T pop() {
            if (dataStack.isEmpty())
                return null;
            minStack.pop();
            return dataStack.pop();
        }
        public T min() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }
}


