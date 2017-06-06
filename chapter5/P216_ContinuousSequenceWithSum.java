package offer.chapter5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/6/1.
 */
public class P216_ContinuousSequenceWithSum {
    public static List<List<Integer>> findContinuousSequence(int sum){
        List<List<Integer>> result = new LinkedList<>();
        if(sum<3)
            return null;
        int left=1,right=2;
        while(left<=(1+sum)/2){
            if((left+right)*(right-left+1)/2==sum){
                List<Integer> temp = new LinkedList<>();
                temp.add(left);
                temp.add(right);
                result.add(temp);
                left++;
            }
            else if((left+right)*(right-left+1)/2<sum)
                right++;
            else
                left++;
        }
        return result;
    }
    public static void main(String[] args){
        List<List<Integer>> result = findContinuousSequence(15);
        System.out.println(result);
    }
}
