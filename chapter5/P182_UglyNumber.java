package offer.chapter5;

/**
 * Created by ryder on 2017/5/31.
 * 获取第n个丑数
 * 丑数，只包含因子2,3,5（把1当做第一个丑数）
 */
public class P182_UglyNumber {
    public static int getUglyNumber(int index){
        if(index<=0)
            return 0;
        int number = 0;
        int uglyFound = 0;
        while(uglyFound<index){
            number++;
            if(isUgly(number))
                uglyFound++;
        }
        return number;
    }
    public static boolean isUgly(int number){
        while(number%5==0)
            number /=5;
        while(number%3==0)
            number /=3;
        while(number%2==0)
            number /=2;
        return number==1;
    }

    public static int getUglyNumber1(int index){
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int curIndex = 0;
        int ugly2index = 0;
        int ugly3index = 0;
        int ugly5index = 0;
        while (true){
            int min = Math.min(Math.min(uglyNumbers[ugly2index]*2,uglyNumbers[ugly3index]*3),uglyNumbers[ugly5index]*5);
            uglyNumbers[++curIndex] = min;
            if(uglyNumbers[ugly2index]*2==uglyNumbers[curIndex])
                ugly2index++;
            if(uglyNumbers[ugly3index]*3==uglyNumbers[curIndex])
                ugly3index++;
            if(uglyNumbers[ugly5index]*5==uglyNumbers[curIndex])
                ugly5index++;
            if(curIndex==index-1)
                break;
        }
        return uglyNumbers[index-1];
    }
    public static void main(String[] args){
        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber1(10));
    }
}
