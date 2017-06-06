package offer.chapter3;

/**
 * Created by ryder on 2017/5/4.
 *
 * if the problem is about an integer with n bits,and n is not limited, need to consider big number.
 * StringBuilder/char[] is an effective sloution.
 */
public class P94_Printt1ToMaxOfNDigits {
    //method 1: do not consider big number problem,overflow may happen.
    public static void print1ToMaxNDigits(int n){
        int number = 1;
        for(int i=0;i<n;i++)
            number *= 10;
        for(int i=1;i<number;i++)
            System.out.println(i);
    }

    //method 2: consider big number problem,settle it with char[]
    public static void print1ToMaxNDigits1(int n){
        if(n<=0)
            return;
        char[] number = new char[n];
        for(int i=0;i<n;i++)
            number[i] = '0';
        while(!isOverflowAfterIncrement(number)){
            printNumber(number);
        }
    }
    public static boolean isOverflowAfterIncrement(char[] number){
        boolean isOverflow = false;
        int carrybit = 0;
        for(int i=number.length-1;i>=0;i--){
            int bitSum = number[i] - '0' + carrybit;
            if(i == number.length-1)
                bitSum++;
            if(bitSum>=10){
                if(i==0)
                    isOverflow = true;
                else{
                    bitSum -= 10;
                    carrybit = 1;
                    number[i] = (char)((int)'0'+bitSum);
                }
            }
            else{
                number[i] = (char)((int)'0'+bitSum);
                break;
            }
        }
        return isOverflow;
    }
    public static void printNumber(char[] number){
        boolean isBeginningWith0 = true;
        for(int i=0;i<number.length;i++){
            if(isBeginningWith0 && number[i]!='0')
                isBeginningWith0 = false;
            if(!isBeginningWith0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    //method 3: recursive,ervery bit from 0 to 9
    public static void print1ToMaxNDigits2(int n){
         if(n<=0)
             return;
        char[] number = new char[n];
        for(int i=0;i<n;i++)
            number[i] = '0';
        for(int i=0;i<=9;i++){

        }
    }
    public static void main(String[] args){
        print1ToMaxNDigits(2);
        print1ToMaxNDigits1(2);
    }
}
