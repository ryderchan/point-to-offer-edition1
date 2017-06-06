package offer.chapter5;

/**
 * Created by ryder on 2017/5/30.
 * 从1到n整数中1出现的次数
 */
public class P174_NumberOf1 {
    // 以2314为例，分为1-314，315-2314两部分
    // 1-314可看成2314删除了第一位，可递归处理recursive
    // 315-2314中1出现的次数与1-2000相同，这是可以再分为两部分，第一位出现1的次数firstNumberSum，其他位1出现的次数otherNumbersSum
    public static int numberOf1Between1AndN(int n){
        if(n<=0)
            return 0;
        StringBuilder number = new StringBuilder(Integer.toString(n));
        return numberOf1(number);
    }
    public static int numberOf1(StringBuilder number){
        if(number.length()==0)
            return 0;
        int firstNumber = (int)number.charAt(0)-(int)'0';
        number.deleteCharAt(0);

        int firstNumberSum = 0;
        if(firstNumber==1)
            firstNumberSum = Integer.parseInt(number.toString())+1;
        else if(firstNumber>1)
            firstNumberSum = powerBased10(number.length());
        int otherNumbersSum = firstNumber*number.length()*powerBased10(number.length()-1);
        int recursive = numberOf1(number);
        return firstNumberSum + otherNumbersSum + recursive;
    }
    public static int powerBased10(int len){
        int result = 1;
        for(int i=0;i<len;i++)
            result *= 10;
        return result;
    }
    public static void main(String[] args){
        System.out.println(numberOf1Between1AndN(12));
    }
}
