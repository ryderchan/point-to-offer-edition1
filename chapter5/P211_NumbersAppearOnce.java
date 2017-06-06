package offer.chapter5;

/**
 * Created by ryder on 2017/6/1.
 * 数组中只出现一次的数字
 * 有两个数字出现一次，其他都出现两次，要求时间0(n),空间0(1)
 */
public class P211_NumbersAppearOnce {
    //借助异或的性质：与自身异或值为0
    //关键问题是如何把两个只出现一次的数分配到两组中
    public static void findNumsAppearOnce(int[] data,int[] nums){
        if(data==null || data.length<2)
            return;
        int resultXOR = 0;
        for(int item:data)
            resultXOR ^= item;
        int indexOf1 = findFirstBitOf1(resultXOR);
        nums[0]=0;
        nums[1]=0;
        for(int item:data){
            if(isBit1ofIndex(item,indexOf1))
                nums[0] ^= item;
            else
                nums[1] ^= item;
        }
    }
    public static int findFirstBitOf1(int number){
        int index = 0;
        while((number&1)==0){
            number = number>>>1;
            index++;
        }
        return index;
    }
    public static boolean isBit1ofIndex(int number,int index){
        return ((number>>>index)&1)==1;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        int[] nums = new int[2];
        findNumsAppearOnce(data,nums);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }
}
