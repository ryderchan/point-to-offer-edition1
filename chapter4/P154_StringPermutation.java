package offer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryder on 2017/5/14.
 * 字符串的排列(全排列问题)
 */
public class P154_StringPermutation {
    //书中的递归思路(前提是待排列元素没有重复)
    //加入第33行的if判断，可对有重序列进行全排列
    //待完成：非递归版本
    //相似问题：八皇后
    public static List<char[]> permutation(char[] s){
        if(s==null || s.length==0)
            return null;
        List<char[]> ret = new ArrayList<>();
        permutationHelper(s,ret,0);
        return ret;
    }
    public static void swap(char[] s,int i,int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public static void permutationHelper(char[] s,List<char[]>ret, int bound){
        if(bound==s.length){
            ret.add(Arrays.copyOf(s,s.length));
        }
        else{
            for(int i=bound;i<s.length;i++){
//                if(i==bound || s[i]!=s[bound] ){
                    swap(s, bound, i);
                    permutationHelper(s, ret, bound + 1);
                    swap(s, bound, i);
//                }
            }
        }
    }
    public static void main(String[] args){
        char[] s1 = new char[]{'a','b','c'};
        List<char[]> ret1 = permutation(s1);
        for(char[] chars:ret1){
            for(char c:chars){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
        char[] s2 = new char[]{'a','b','a'};
        List<char[]> ret2 = permutation(s2);
        for(char[] chars:ret2){
            for(char c:chars){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
