package offer.chapter2;

import sun.security.util.Length;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class P44_ReplaceBlank {
    // time: o(n^2)
    public static void replaceBlank1(StringBuilder str){
        for(int i=0;i<str.length();){
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
                i = i + 3;
            }
            else i++;
        }
    }
    // time: o(n)
    public static void replaceBlank2(StringBuilder str){
        int numberOfBlank = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                numberOfBlank++;
        }
        if(numberOfBlank==0)
            return;
        int originalLength = str.length();
        int newLength = originalLength + 2*numberOfBlank;
        str.setLength(newLength);
        int indexOfOriginal = originalLength-1;
        int indexOfNew = newLength-1;
        while(indexOfOriginal>=0 && indexOfNew>indexOfOriginal){
            if(str.charAt(indexOfOriginal)==' '){
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
                indexOfOriginal--;
            }
            else{
                str.setCharAt(indexOfNew--,str.charAt(indexOfOriginal--));
            }
        }
    }
    public static void  main(String[] args){
        StringBuilder  s1 = new StringBuilder("We are happy.");
        replaceBlank1(s1);
        System.out.println(s1);
        StringBuilder  s2 = new StringBuilder("We are happy.");
        replaceBlank2(s2);
        System.out.println(s2);

    }
}
