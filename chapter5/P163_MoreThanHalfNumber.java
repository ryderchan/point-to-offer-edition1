package offer.chapter5;

/**
 * Created by ryder on 2017/5/19.
 * 数组中出现次数超过一半的数字
 */
public class P163_MoreThanHalfNumber {
    //使用快排的分区函数，得到中位数，时间复杂度o(n)
    public static int moreThanHalfNum(int[] data){
        if(data==null || data.length==0)
            return 0;
        int middle = data.length>>1;
        int start = 0;
        int end = data.length-1;
        int index = partition(data,start,end);
        while(index!=middle){
            if(index<middle)
                start = index+1;
            else
                end = index-1;
            index = partition(data,start,end);
        }
        return  data[index];
    }
    public static int partition(int[] data,int start,int end){
        int pivot = data[start];
        int left = start,right = end;
        while(left<right){
            while(left<right && data[right]>=pivot)
                right--;
            if(left<right)
                data[left++] = data[right];
            while(left<right && data[left]<pivot)
                left++;
            if(left<right)
                data[right--] = data[left];
        }
        data[left] = pivot;
        return left;
    }

    //不修改原始数据，思路新颖，时间复杂度o(n)
    public static int moreThanHalfNum2(int[] data) {
        if(data==null || data.length==0)
            return 0;
        int prevNum = 0;
        int times = 0;
        for(int num:data){
            if(num==prevNum)
                times++;
            else{
                if(times==0)
                    prevNum = num;
                else
                    times--;
            }
        }
        return prevNum;
    }
    public static void main(String[] args){
        int[] data = {4,5,5,4,5,5,5};
        System.out.println(moreThanHalfNum(data));
        System.out.println(moreThanHalfNum2(data));
    }
}
