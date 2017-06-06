package offer.chapter5;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ryder on 2017/5/19.
 * 最小的k个数
 * o(nlogk),适合处理海量数据，需要实现最大堆
 */

public class P168_KLeastNumbers {
    /**
     * 使用最大堆的好处可以很容易或的堆的最大值，即1号元素
     * 最大堆内保存一个数组data，用来保存k个最小值，其中0号元素不适使用，curIndex为堆中已存数据的最大下标值，也表明了已经存入的数据个数。
     * 比较关键的是add函数，如果curIndex小于size，找到合适位置存入即可。如果等于size，需要删去1号元素，然后调整堆，找到合适位置存入value。
     */
    private static class MaxHeap{
        private int[] data;
        private int size;
        private int curIndex; // 0号元素不使用
        public MaxHeap(int size) {
            this.size = size;
            this.data = new int[this.size+1];
            this.curIndex = 0;
        }
        public void add(int value){
            if(curIndex==0)
                this.data[++curIndex]=value;
            //调整堆
            else if(curIndex == this.size && value<this.data[1]){
                int parent = 1;
                int current = parent*2;
                while(current<=size){
                    int maxIndex = current;
                    if(current+1<=size && this.data[current]<this.data[current+1])
                        maxIndex = current + 1;
                    if(value<this.data[maxIndex]) {
                        this.data[parent] = this.data[maxIndex];
                        parent = maxIndex;
                        current = parent * 2;
                    }
                    else{
                        break;
                    }
                }
                this.data[parent] = value;

            }
            else{
                curIndex++;
                int parent = this.curIndex/2;
                int current = this.curIndex;
                while (parent>=1){
                    if(this.data[parent]<value){
                        this.data[current] = this.data[parent];
                        current = parent;
                        parent = current/2;
                    }
                    else{
                        break;
                    }
                }
                this.data[current] = value;
            }
        }
        public Integer[] getData(){
            Integer[] result = new Integer[this.size];
            for(int i=0;i<this.size;i++){
                result[i] = this.data[i+1];
            }
            return result;
        }
    }

    public static List<Integer> kLeastNumbers(List<Integer> data, int k){
        MaxHeap maxHeap = new MaxHeap(k);
        for(int item:data)
            maxHeap.add(item);
        List<Integer> list = new ArrayList<>(Arrays.asList(maxHeap.getData()));
        return list;
    }

    public static void main(String[] args){
        List<Integer> data = new LinkedList<>();
        data.add(1);
        data.add(3);
        data.add(6);
        data.add(5);
        data.add(4);
        data.add(2);
        List<Integer> ret = kLeastNumbers(data,4);
        System.out.println(ret);
    }
}
