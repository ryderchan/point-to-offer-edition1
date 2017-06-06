package offer.chapter2;

/**
 * Created by ryder on 2017/5/3.
 *
 * bitwise operator
 * & | ~ ^
 * << :left shift,filling with 0
 * >> :right shift,filling with flag bit(+ with 0,- with 1)
 * >>>:right shift,filling with 0
 *
 * related problems:
 * if an Integer is  2^x  =>  if there is only one "1" in the binary form of that integer;
 * change how many bit can let m to n => first, m^n;second, count how many "1" in m^n;
 */
public class P78_NumberOf1InBinary {
    public static int numberOf1InBinary(int n){
        int count = 0;
        while(n!=0){
            count += n&1;
            n=n>>>1;
        }
        return count;
    }
    public static int numberOf1InBinary2(int n){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)!=0)
                count += 1;
            flag=flag<<1;
        }
        return count;
    }
    public static int numberOf1InBinary3(int n){
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }


    public static void main(String[] args){
        int x = -800000;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(numberOf1InBinary(x));
        System.out.println(numberOf1InBinary2(x));
        System.out.println(numberOf1InBinary3(x));

    }
}
