package offer.chapter5;

/**
 * Created by ryder on 2017/6/1.
 * 求1+2+...n，不使用乘除法和循环与判断语句，如for,while,if,switch,?;
 * java中能够省略if的一种方式：boolean b=判断条件&&待执行语句>0
 */
public class P233_Accumulate {
    //Temp[] t1 = new Temp[10];  //只是声明，非实例化，不会调用构造函数
    //需要实例化10次才行，与1+2+...10一样,通过构造函数不可行
    private static class Temp{
        private static int N;
        private static int Sum;
        static {
            N = 0;
            Sum = 0;
        }
        public Temp(){
            N++;
            Sum += N;
        }
        public static int getSum(){
            return Sum;
        }
    }
    //通过递归函数，注意省略if的写法：boolean b=判断条件&&待执行语句>0
    public static int getSum(int n){
        int t = 0;
        boolean b = (n > 0) && ((t = getSum(n - 1) + n) >0);
        return t;
    }
    public static void main(String[] args){
        System.out.println(getSum(10));
    }
}
