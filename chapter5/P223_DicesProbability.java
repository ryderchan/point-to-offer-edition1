package offer.chapter5;

/**
 * Created by ryder on 2017/6/1.
 *
 */
public class P223_DicesProbability {
    //递归:结果取值为number~number*6，下标为0~number*6-number,错位number
    public static void printProbability(int number){
        if(number<1)
            return;
        int[] probabilities = new int[number*6-number+1];
        probability(number,0,0,probabilities);
        float total = 1;
        for(int i=0;i<number;i++)
            total *= 6;
        for(int i=0;i<probabilities.length;i++){
            System.out.print(i+number);
            System.out.print(":"+'\t');
            System.out.println(probabilities[i]/total);
        }
    }
    public static void probability(int originalNumber,int usedNumber,int sum,int[] probabilities){
        if(usedNumber==originalNumber)
            probabilities[sum-originalNumber]++;
        else{
            for(int i=1;i<=6;i++)
                probability(originalNumber,usedNumber+1,sum+i,probabilities);
        }
    }
    //迭代：加入第k个骰子得到和n的次数为加入第k-1个骰子后n-1,n-2...n-6这这个次数之和。
    //DP中的表格法，见http://blog.csdn.net/xianliti/article/details/5644118
    public static void printProbability1(int number){
        if(number<1)
            return;
        int[][] probabilities = new int[2][number*6+1];
        //flag表示的是当前用于存储有用信息的probabilities的行号，另一行则为辅助
        int flag = 0;
        for(int i=0;i<2;i++) {
            for (int j=0; j<number*6+1; j++) {
                probabilities[i][j] = 0;
            }
        }
        for(int i=1;i<=6;i++)
            probabilities[flag][i] = 1;
        flag = 1 - flag;
        for(int k=2;k<=number;k++){
            for(int j=0;j<number*6+1;j++)
                probabilities[flag][j] = 0;
            for(int i=k;i<=6*k;i++){
                int step = 1;
                while(step<=6 && i-step>0) {
                    probabilities[flag][i] +=  probabilities[1-flag][i-step];
                    step++;
                }
            }
            flag = 1 - flag;
        }
        float total = 1;
        for(int i=0;i<number;i++)
            total *= 6;
        for(int i=number;i<probabilities[1-flag].length;i++){
            System.out.print(i);
            System.out.print(":"+'\t');
            System.out.println(probabilities[1-flag][i]/total);
        }
    }
    public static void main(String[] args){
        printProbability(2);
        System.out.println();
        printProbability1(2);
    }
}
