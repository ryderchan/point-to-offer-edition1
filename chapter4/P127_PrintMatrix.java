package offer.chapter4;

/**
 * Created by ryder on 2017/5/9.
 */
public class P127_PrintMatrix {
    public static void printMatrixClockwisely(int[][] data){
        if(data==null)
            return;
        int circles = (data.length/2+1)>(data[0].length/2+1)?data.length/2+1:data[0].length/2+1;
        for(int c=0;c<circles;c++){
            printMatrixInCircle(data,c);
        }
    }
    public static void printMatrixInCircle(int[][] data,int circle){
        int row = circle;
        int col = circle;
        int rowLen = data.length;
        int colLen = data[0].length;
        //特殊情况（当前圈仅由一行组成）
        if(data.length == circle*2+1){
            for(;col<=colLen-1-circle;col++){
                System.out.print(data[row][col]);
                System.out.print('\t');
            }
            return;
        }
        //特殊情况（当前圈仅由一列组成）
        if(data.length == circle*2+1){
            for(;row<=rowLen-1-circle;row++){
                System.out.print(data[row][col]);
                System.out.print('\t');
            }
            return;
        }
        for(;col<colLen-1-circle;col++){
            System.out.print(data[row][col]);
            System.out.print('\t');
        }
        for(;row<rowLen-1-circle;row++){
            System.out.print(data[row][col]);
            System.out.print('\t');
        }
        for(;col>circle;col--){
            System.out.print(data[row][col]);
            System.out.print('\t');
        }
        for(;row>circle;row--){
            System.out.print(data[row][col]);
            System.out.print('\t');
        }
    }
    public static void main(String[] args){
        int[][] data ={
                {1 ,2 ,3 ,4 ,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}
        };
        printMatrixClockwisely(data);
    }
}
