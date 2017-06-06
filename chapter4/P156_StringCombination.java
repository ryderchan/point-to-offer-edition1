package offer.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryder on 2017/5/15.
 *
 */
public class P156_StringCombination {
    public static List<char[]> combinationRecursion(char[] s){
        if(s==null || s.length==0)
            return null;
        List<char[]> ret = new ArrayList<>();
        combinationHelper(s,ret,0,new StringBuilder());
        return ret;
    }
    public static void combinationHelper(char[] s,List<char[]> ret,int cur,StringBuilder curStr){
        if(cur==s.length)
            ret.add(curStr.toString().toCharArray());
        else {
            combinationHelper(s, ret, cur + 1, new StringBuilder(curStr));
            combinationHelper(s, ret, cur + 1, curStr.append(s[cur]));
        }
    }

    public static void main(String[] args){
        char[] s1 = new char[]{'a','b','c'};
        List<char[]> ret1 = combinationRecursion(s1);
        for(char[] chars:ret1){
            for(char c:chars){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
