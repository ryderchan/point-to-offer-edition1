package offer.chapter3;

/**
 * Created by ryder on 2017/5/4.
 *
 * three way to deal with exception:
 * 1.return a speical value,such as 0,-1;
 * 2.use a global variable as a exception flag;
 * 3.throw new Exception();
 *
 * judge a float/double is equal to another float/double:
 * cannot user ==,need to consider precision.
 *
 * calculate the integer value of x/2:
 * int x=13;
 * int y = x/2; ==> int y = x>>2 (when x>=0)
 *
 * the priority of bit operator :
 * in java, & | is higher than && ||, but lower than ==,>,<; (ATTENTION)
 * <<,>>,>>>,is higher than ==,>,<;
 * http://www.cnblogs.com/gw811/archive/2012/10/13/2722752.html
 *
 * judge if an integer can be divided by 2:
 * int x=13;
 * if(x%2==1)   ==> if((x&0x1) == 1)
 *
 */
public class P90_PowerWithUnsignedExponent {
    //without considering special condition,such as exponent<0 and base=0;
    public static double power(double base,int exponent){
        double result = 1.0;
        for(int i=1;i<=exponent;i++)
            result *= base;
        return result;
    }

    public static boolean invalidInput = false;
    public static double power1(double base,int exponent){
        invalidInput = false;
        if(isEqual(base,0.0)&&exponent<0) {
            invalidInput = true;
            return 0.0;
        }
        int flag = 1;
        if(exponent<0){
            flag = -1;
            exponent *= -1;
        }
        double result = powerWithUnsignedExponent(base,exponent);
        if(flag==-1)
            result = 1.0/result;
        return result;
    }
    public static boolean isEqual(double d1,double d2){
        if((d1-d2)>-0.0000001 && (d1-d2)<0.0000001)
            return true;
        else
            return false;
    }
    public static double powerWithUnsignedExponent(double base,int exponent){
//        double result = 1.0;
//        for(int i=1;i<=exponent;i++)
//            result *= base;
//        return result;
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        double result = powerWithUnsignedExponent(base,exponent>>1);
        result *= result;
        //the priority of & is bigger than &&,but lower than ==;must use () here;
        if((exponent &0x1) == 1)
            result *= base;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(power(2,3));
        System.out.println(power1(2,3));
        System.out.println(power(2,-3));
        System.out.println(power1(2,-3));
        System.out.println(power(0,-1));
        System.out.println(power1(0,-1));
        System.out.println(invalidInput);
    }
}
