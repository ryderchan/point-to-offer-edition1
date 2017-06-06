package offer.chapter2;

import java.sql.Time;
import java.util.Random;

/**
 * Created by ryder on 2017/5/3.
 *
 */
public class P64_QuickSort {
    public static void quickSort(int[] data,int start,int end) throws Exception{
        if(data.length==0 || start<0 || end>=data.length)
            throw new Exception("wrong input!");
        if(start>=end)
            return;
        int index = partition2(data,start,end);
        quickSort(data,0,index-1);
        quickSort(data,index+1,end);
    }
    public static int partition(int[] data,int start,int end){
        Random rand = new Random();
        int index = rand.nextInt(end-start+1)+start;
        int pivot = data[index];
        data[index] = data[start];
        int left = start;
        int right = end;
        while(left<right){
            while(data[right]>=pivot && left<right)
                right--;
            if(left<right){
                data[left] = data[right];
                left++;
            }
            while(data[left]<pivot && left<right)
                left++;
            if(left<right){
                data[right] = data[left];
                right--;
            }
        }
        data[left] = pivot;
        return left;
    }
    public static int partition2(int[] data,int start,int end){
        //nextInt(10) => [0,10), partion range include start and end point
        Random rand = new Random();
        int index = rand.nextInt(end-start+1)+start;
        int temp = data[index];
        data[index] = data[end];
        data[end] = temp;
        int smallBound = start-1;
        for(int i=start;i<end;i++){
            if(data[i]<data[end]){
                temp = data[++smallBound];
                data[smallBound] = data[i];
                data[i] = temp;
            }
        }
        temp = data[++smallBound];
        data[smallBound] = data[end];
        data[end] = temp;
        return smallBound;
    }

    public static void main(String[] args) {
        int[] data = {3,1,5,6,2,4};
        try {
            quickSort(data, 0, data.length - 1);
            for(int d:data){
                System.out.print(d);
                System.out.print("\t");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
