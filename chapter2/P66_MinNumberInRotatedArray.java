package offer.chapter2;

/**
 * Created by ryder on 2017/5/3.
 *
 */
public class P66_MinNumberInRotatedArray {
    public static int min(int[] data){
        int left = 0;
        int right = data.length-1;
        int mid = left;
        while(data[left]>=data[right]){
            mid = left+(right-left)/2;
            if(right-left<=1)
                return data[right];
            if(data[mid]==data[left] && data[mid]==data[right]){
                left++;
                right--;
            }
            else if(data[mid]>=data[left]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return data[mid];
    }
    public static void main(String[] args){
        System.out.println(min(new int[]{4,5,6,1,2,3}));
        System.out.println(min(new int[]{5,5,5,1,5,5}));
    }
}
