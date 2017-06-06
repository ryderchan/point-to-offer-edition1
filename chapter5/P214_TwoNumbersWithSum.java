package offer.chapter5;

/**
 * Created by ryder on 2017/6/1.
 * 和为s的两个数字
 */
public class P214_TwoNumbersWithSum {
    public static boolean findTwoNumberWithSum(int data[],int[] nums,int sum){
        boolean found = false;
        if(data==null || data.length<2)
            return false;
        int left = 0,right = data.length-1;
        while (left<right){
            if(data[left]+data[right]==sum){
                nums[0] = data[left];
                nums[1] = data[right];
                return true;
            }
            if(data[left]+data[right]>sum)
                right--;
            else
                left++;
        }
        return false;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        int[] nums = new int[]{0,0};
        System.out.println(findTwoNumberWithSum(data,nums,15));
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }
}
