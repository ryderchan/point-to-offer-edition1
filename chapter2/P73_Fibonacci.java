package offer.chapter2;

/**
 * Created by ryder on 2017/5/3.
 *
 * the feature of Fibonacci : f(n) = f(n-1) + f(n-2)
 * the same question: Frog jump step
 */
public class P73_Fibonacci {
    //o(n^2)
    public static long fibonacci(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    //o(n)
    public static long fibonacci2(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        long temp1 = 0,temp2 = 1,temp3=0;
        for(int i=2;i<=n;i++){
            temp3 = temp1+temp2;
            temp1 = temp2;
            temp2 = temp3;
        }
        return temp3;
    }

    //o(logn)
    //   [ f(n)  f(n-1) ]  =   [ 1  1 ] ^n-1
    //   [f(n-1) f(n-2) ]      [ 1  0 ]
    public static long fibonacci3(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        long[][] matrix = new long[][]{{1,1},{1,0}};
        return multiplyPower(matrix,n-1)[0][0];
    }

    public static long[][] multiplyPower(long[][] matrix,int times){
        if(times==1)
            return matrix;
        if(times%2==0){
            long[][] temp = multiplyPower(matrix,times/2);
            return multiply(temp,temp);
        }
        else{
            long[][] temp = multiplyPower(matrix,(times-1)/2);
            temp = multiply(temp,temp);
            return multiply(temp,matrix);
        }
    }
    public static long[][] multiply(long[][] matrix1,long[][] matrix2){
        long[][] result = new long[matrix1.length][matrix2[0].length];
        for(int i=0;i<matrix1.length;i++){
            for(int j=0;j<matrix2[0].length;j++){
                result[i][j] = 0;
                for(int k=0;k<matrix1[0].length;k++){
                    result[i][j] += matrix1[i][k]*matrix2[j][k];
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int n = 20;
        System.out.println(fibonacci(n));
        System.out.println(fibonacci2(n));
        System.out.println(fibonacci3(n));
    }

}
