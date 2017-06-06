package offer.chapter5;

/**
 * Created by ryder on 2017/6/1.
 */
public class P218_ReverseWordsInSentence {
    //通过String的split完成
    public static String reverseSentence(String str){
        if(str==null)
            return null;
        str = str.trim();
        String[] strs = str.split(" ");
        StringBuilder strb = new StringBuilder();
        for(int i=strs.length-1;i>=0;i--)
            strb.append(strs[i]).append(" ");
        return strb.toString().trim();
    }
    //通过String的lastIndexOf,递归完成
    public static String reverseSentence1(String str){
        if(str==null)
            return null;
        str = str.trim();
        return str.lastIndexOf(" ")==-1? str:str.substring(str.lastIndexOf(" ")+1)+" "+reverseSentence1(str.substring(0,str.lastIndexOf(" ")));
    }
    //通过两次翻转
    public static String reverseSentence2(String str){
        if(str==null)
            return null;
        str = str.trim();
        StringBuilder strb = new StringBuilder(str);
        strb.reverse();
        int startIndex = 0;
        int endIndex = 0;
        while(strb.indexOf(" ",startIndex)!=-1){
            endIndex = strb.indexOf(" ",startIndex)-1;
            for(int i=startIndex;i<=(startIndex+endIndex)/2;i++){
                char temp = strb.charAt(i);
                strb.setCharAt(i,strb.charAt(endIndex-i));
                strb.setCharAt(endIndex-i,temp);
            }
            startIndex = strb.indexOf(" ",startIndex) + 1;
        }
        return strb.toString();
    }
    public static void main(String[] args){
        String str = "I am a student. ";
        System.out.println(reverseSentence(str));
        System.out.println(reverseSentence1(str));
        System.out.println(reverseSentence2(str));
    }
}
