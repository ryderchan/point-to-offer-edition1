package offer.chapter5;

import java.util.Arrays;

/**
 * Created by ryder on 2017/6/1.
 * 扑克牌顺子
 * 几个关键点：
 * 1.大小王记作0,对5张牌进行排序
 * 2.如果有对子（0除外），不可能成为顺子
 * 3.0的个数如果比差值(1与4的差值定义为2，即距离-1，代表缺失数字个数)之和小，就是顺子，否则不是
 */
public class P226_ContinousCards {
    public static boolean isContinuous(int[] data){
        if(data==null || data.length!=5)
            return false;
        Arrays.sort(data);
        int zeros = 0;
        while(data[zeros]==0)
            zeros++;
        int prev = data[zeros],diff = 0;
        for(int i=zeros+1;i<data.length;i++){
            if(data[i]==prev)
                return false;
            else{
                diff += data[i]-prev-1;
                prev = data[i];
            }
        }
        return diff<=zeros;
    }
    public static void main(String[] args){
        int[] data_false = {0,0,1,7,2};
        int[] data_true = {0,0,1,5,2};
        System.out.println(isContinuous(data_false));
        System.out.println(isContinuous(data_true));
    }
}
