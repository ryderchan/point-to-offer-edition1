package offer.chapter5;

/**
 * Created by ryder on 2017/5/30.
 * 连续子数组的最大和
 */
public class P171_GreatestSumOfSubarrays {
    /**
     * 动态规划:
     * dp(i) =  data[i]            dp(i-1)<=0 or i=0
     *          dp(i-1)+data[i]    dp(i-1)>0  and i>0
     * return  max(dp)
     * dp[i]整个数组可以省略，只记录当前和即可，根据当前和更新最大和
     */
    public static int findGreatestSumOfSubArray(int [] data){
        int dp = 0;
        int maxdp = 0;
        for(int item : data){
            if(dp<=0)dp = item;
            else dp += item;
            if(dp>maxdp)
                maxdp = dp;
        }
        return maxdp;
    }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSubArray(data));
    }
}
