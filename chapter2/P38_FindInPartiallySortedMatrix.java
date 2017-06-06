package offer.chapter2;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class P38_FindInPartiallySortedMatrix {
    public static boolean  find(int[][] matrix,int number){
        int rows = matrix.length;
        int columns = -1;
        if(rows>0)
            columns = matrix[0].length;
        int row=0;
        int column = columns - 1;
        while(row<rows && column>=0){
            if(matrix[row][column]==number)
                return true;
            else if(matrix[row][column]>number)
                column--;
            else
                row++;
        }
        return false;
    }
    public static void  main(String[] args){
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(find(matrix,7));
        System.out.println(find(matrix,5));
    }
}
