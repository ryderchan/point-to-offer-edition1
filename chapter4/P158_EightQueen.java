package offer.chapter4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/5/16.
 *
 */
public class P158_EightQueen {
    public static List<List<Integer>> eightQueue(){
        Integer[] columnIndexInt = {0,1,2,3,4,5,6,7};
        List<Integer> columnIndex = new LinkedList<>(Arrays.asList(columnIndexInt));
        List<List<Integer>> ret = new LinkedList<>();
        intPermutation(ret,columnIndex,0);
        deleteBad(ret);
        return ret;

    }
    public static void intPermutation(List<List<Integer>> ret,List<Integer> data,int index){
        if(index==data.size()) {
            ret.add(data);
            return;
        }
        for(int i=index;i<data.size();i++){
            List<Integer> newData = new LinkedList<>(data);
            int temp = newData.get(i);
            newData.set(i,newData.get(index));
            newData.set(index,temp);
            intPermutation(ret,newData,index+1);
        }
    }
    public static void deleteBad(List<List<Integer>> ret){
        boolean delete = false;
        for(int i=0;i<ret.size();){
            for(int j=0;j<ret.get(i).size()-1;j++){
                for(int k=j+1;k<ret.get(i).size();k++){
                    if(Math.abs(ret.get(i).get(j)-ret.get(i).get(k))==k-j){
                        delete = true;
                        break;
                    }
                }
                if(delete)
                    break;
            }
            if(delete) {
                ret.remove(i);
                delete = false;
            }
            else{
                i++;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("□□□□□□□□");
        System.out.println("□□□□■□□□");

        List<List<Integer>> ret = eightQueue();
        for(int i=0;i<ret.size();i++){
            System.out.print("第"+(i+1)+"种:");
            System.out.println(ret.get(i));
        }
    }


}
