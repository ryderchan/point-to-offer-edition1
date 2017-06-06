package offer.chapter3;

/**
 * Created by ryder on 2017/5/7.
 *
 */
public class P103_ReorderArray {
    //奇数在前，偶数在后
    //解耦的好处：提高了代码的重用性，为功能扩展提供了遍历
    //java不能像C++那样把函数名作为函数参数，一种解决方案是把判断函数封装到一个类中，
    //之后把类的一个对象作为参数传递；或者把该类以及类中方法声明为static，如下
    public static void reorderOddEven(int[] data){
        if(data==null)
            return;
        for(int left=0,right=data.length-1;left<right;left++,right--){
            while(left<right && !Judement.isEven(data[left]))
                left++;
            while(left<right && Judement.isEven(data[right]))
                right--;
            if(left<right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
            else{
                break;
            }
        }
    }
    public static class Judement{
        public static boolean isEven(int n){
            return (n&0x1)==0;
        }
        //We can add other rules here.
    }
    public static void main(String[] args){
        int[] data={1,2,3,4,5};
        reorderOddEven(data);
        for(int i=0;i<data.length;i++)
            System.out.println(data[i]);
    }
}
