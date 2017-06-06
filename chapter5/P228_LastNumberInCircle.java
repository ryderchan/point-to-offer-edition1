package offer.chapter5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/6/1.
 * 圆圈中最后剩下的在数字（约瑟夫环问题）
 */
public class P228_LastNumberInCircle {
    //循环链表解决方法（使用单链表模拟）
    //时间o(mn),空间o(n)
    public static int lastRemaining(int[] data,int m){
        if(data==null || data.length==0)
            return -1;
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<data.length;i++)
            list.add(data[i]);
        int curIndex = -1;
        while(list.size()>1){
            curIndex = (curIndex+m)%list.size();
//            System.out.println(list.get(curIndex));
            list.remove(curIndex);
            curIndex = curIndex-1;//删除当前点，后一节点的index会小1，此处回退一步
        }
        return list.get(0);
    }
    //使用数学推导
    public static int lastRemaining1(int[] data,int m){
        if(data==null || data.length<1 || m<1)
            return -1;
        int s = 0;
        for(int i=2;i<=data.length;i++){
            s = (s+m)%i;
        }
        return data[s];
    }

    //http://blog.163.com/soonhuisky@126/blog/static/157591739201321341221179/
    //先去掉第m个（起点是0，或1都测试），然后依次从1报数，报到k去掉
    public static int lastRemainingVariant(int[] data,int m,int k){
        if(data==null || data.length<1 || m<1)
            return -1;
        int s = 0;
        for(int i=2;i<data.length;i++){
            s = (s+k)%i;
        }
        s = (s+m)%data.length;
        return data[s];
    }
    public static void main(String[] args){
        int[] data = {0,1,2,3,4};
        System.out.println(lastRemaining(data,3)); //3
        System.out.println(lastRemaining1(data,3));//3

        System.out.println();
        System.out.println(lastRemainingVariant(data,3,3)); //3
        int[] data1 = {1,2,3,4,5};
        System.out.println(lastRemainingVariant(data1,1,3)); //2
    }
}
