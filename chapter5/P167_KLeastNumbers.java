package offer.chapter5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/5/19.
 * 最小的k个数
 */
public class P167_KLeastNumbers {
    //快排的分区函数（换用list实现），会修改原始数据，时间复杂度o(n)
    public static List<Integer> kLeastNumbers(List<Integer> data,int k){
        if(data==null || data.size()==0)
            return null;
        int start = 0;
        int end = data.size()-1;
        int index = partition(data,start,end);
        while(index!=k){
            if(index<k) {
                start = index + 1;
            }
            else {
                end = index - 1;
            }
            index = partition(data,start,end);
        }
        List<Integer> ret = new LinkedList<>();
        for(int i=0;i<k;i++)
            ret.add(data.get(i));
        return ret;
    }
    public static int partition(List<Integer> data,int start,int end){
        int pivot = data.get(start);
        int left = start;
        int right = end;
        while(left<right){
            while(left<right && data.get(right)>=pivot)
                right--;
            if(left<right) {
                data.set(left,data.get(right));
                left++;
            }
            while(left<right && data.get(left)<pivot)
                left++;
            if(left<right) {
                data.set(right,data.get(left));
                right--;
            }
        }
        data.set(left,pivot);
        return left;
    }
    public static void main(String[] args){
        List<Integer> data = new LinkedList<>();
        data.add(1);
        data.add(3);
        data.add(5);
        data.add(4);
        data.add(2);
        List<Integer> ret = kLeastNumbers(data,4);
        System.out.println(ret);
    }
}
