package offer.chapter5;

import java.util.HashMap;

/**
 * Created by ryder on 2017/5/31.
 * 第一个只出现一次的字符(char类型)
 * 相似问题：
 * 从第一个字符串中删除在第二个字符中出现过的字符
 * 删除字符串中的重复字符
 * 判断是否是变位词，如silent，listen
 */
public class P186_FirstNotRepeatingChar {
    //如果仅仅是char（8bit），可以用一个数组模拟哈希表
    public static char firstNotRepeatingChar(String str){
        int[] hashTable = new int[256];
        for(int i=0;i<hashTable.length;i++)
            hashTable[i]=0;
        for(int i=0;i<str.length();i++)
            hashTable[(int)str.charAt(i)]++;
        for(int i=0;i<str.length();i++){
            if(hashTable[(int)str.charAt(i)]==1)
                return str.charAt(i);
        }
        return 0;
    }
    //如果包含中文，需要使用hashmap结构
    public static char firstNotRepeatingCharacter(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            if(map.containsKey(str.charAt(i)))
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            else
                map.put(str.charAt(i),1);
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)
                return str.charAt(i);
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(firstNotRepeatingChar("ababcdef"));

        //报错ArrayIndexOutOfBoundsException,因为中的整数值为20013，超过了255
//        System.out.println(firstNotRepeatingChar("abab中cdef"));

        System.out.println(firstNotRepeatingCharacter("abab中cdef"));
    }

}
