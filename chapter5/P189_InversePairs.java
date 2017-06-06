package offer.chapter5;

/**
 * Created by ryder on 2017/5/31.
 *
 */
public class P189_InversePairs {
    public static int inversePairs(int[] data){
        if(data==null || data.length<2)
            return 0;
        int[] dataCopyTo = new int[data.length];
        return inversePairsCore(data,dataCopyTo,0,data.length-1);
    }
    //与归并排序类似，使用分治策略完成
    public static int inversePairsCore(int[] data,int[] dataCopyTo,int start,int end){
        if(start==end)
            return 0;
        int len = (end-start)/2;
        int left = inversePairsCore(data,dataCopyTo,start,start+len);
        int right = inversePairsCore(data,dataCopyTo,start+len+1,end);
        int i = start + len;    //左侧的最后一个元素下标
        int j = end;    //右侧的最后一个元素下标
        int indexCopy = end;    //dataCopy的下标，从右侧开始存放
        int count = 0;          //记录逆序对个数
        while(i>=start && j>=start+len+1){
            if(data[i]>data[j]){
                dataCopyTo[indexCopy--] = data[i--];
                count += j-start-len;
            }
            else{
                dataCopyTo[indexCopy--] = data[j--];
            }
        }
        while(i>=start)
            dataCopyTo[indexCopy--] = data[i--];
        while(j>=start+len+1)
            dataCopyTo[indexCopy--] = data[j--];

        for(int k = start;k<=end;k++)
            data[k] = dataCopyTo[k];

        return left+right+count;
    }
    public static void main(String[] args){
        int[] data = {7,5,6,4};
        System.out.println(inversePairs(data));
   }
}
