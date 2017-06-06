package offer.chapter4;

import java.util.Stack;

/**
 * Created by ryder on 2017/5/9.
 * 栈的压入、弹出序列
 */
public class P134_StackPushPopOrder {
    public static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        if(pushOrder==null || popOrder==null || pushOrder.length!=popOrder.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pushIndex=0,popIndex=0;
        while(true){
            if(popIndex==popOrder.length)
                return true;
            else if(!stack.isEmpty() && stack.peek()==popOrder[popIndex]) {
                stack.pop();
                popIndex++;
            }
            else if(pushIndex<pushOrder.length){
                stack.push(pushOrder[pushIndex]);
                pushIndex++;
            }
            else
                return false;
        }
    }
    public static void main(String[] args){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder1 = {4,3,5,2,1};
        int[] popOrder2 = {4,3,5,1,2};
        System.out.println(isPopOrder(pushOrder,popOrder1));
        System.out.println(isPopOrder(pushOrder,popOrder2));
    }
}
