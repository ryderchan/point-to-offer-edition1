package offer.chapter2;

/**
 * Created by ryder on 2017/5/31.
 *
 */
public class P204_NumberOfK {
    public static int getNumberOfK(int[] numbers,int k){
        if(numbers==null || numbers.length==0)
            return 0;
        int leftIndex = getLeftIndexOfK(numbers,k);
        int rightIndex = getRightIndexOfK(numbers,k);
        return rightIndex-leftIndex+1;
    }
    public static int getLeftIndexOfK(int[] number,int k){
        int left = 0;
        int right = number.length-1;
        int mid;
        while(left<=right){
            if(number[left]==k)
                return left;
            mid = left+(right-left)/2;
            if(number[mid]==k)
                right = mid;
            else if(number[mid]>k)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
    public static int getRightIndexOfK(int[] number,int k){
        int left = 0;
        int right = number.length-1;
        int mid;
        while(left<=right){
            if(number[right]==k)
                return right;
            mid = left+(right-left)/2;
            if(number[mid]==k)
                left = mid;
            else if(number[mid]>k)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] numbers = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(numbers,3));

    }
}
