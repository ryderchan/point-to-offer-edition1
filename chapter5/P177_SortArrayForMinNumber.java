package offer.chapter5;

import java.util.Arrays;

/**
 * Created by ryder on 2017/5/30.
 * 把数组排成最小的数
 * lambda表达式:按照x坐标升序排列
 * Arrays.sort(points,new Comparator<int[]>(){
 *     @override
 *     public int compare(int[] a,int[] b){
 *         return a[0]-b[0];
 *     }
 * });
 * Arrays.sort(points,Comparator.comparing(a->a[0]));
 * Arrays.sort(points,(a,b)->a[0]-b[0]);
 * return值为负，表示a<b,默认按照升序排列
 * 注：points需要为一个集合变量，它的每一个对象不能是基本类型。
 */
public class P177_SortArrayForMinNumber {
    public static String printMinNumber(int[] numbers){
        String[] str = new String[numbers.length];
        for(int i=0;i<str.length;i++){
            str[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(str,(s1,s2)->Integer.parseInt(s1+s2)-Integer.parseInt(s2+s1));
        StringBuilder ret = new StringBuilder();
        for(String s:str)
            ret.append(s);
        return ret.toString();
    }
    public static void main(String[] args){
        int[] numbers = {3,32,321};
        System.out.println(printMinNumber(numbers));
    }
}
