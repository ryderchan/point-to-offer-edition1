package offer.chapter5;

/**
 * Created by ryder on 2017/6/2.
 * 不使用加减乘除做加法
 * 一个数字记录异或值，另一个记录与值左移一位的值
 * 01101  =>   ^ 00110  => 10100 => 10000 => 11000
 * 01011    & <1 10010     00100    01000    00000
 */
public class P237_addTwoNumbers {
    public static int add(int a,int b){
        while(b!=0) {
            int tempa = a;
            a = a^b;
            b = (tempa & b) << 1;
        }
        return a;
    }
    public static void main(String[] args){
        int a=13,b=11;
        System.out.println(add(a,b));
    }
}
