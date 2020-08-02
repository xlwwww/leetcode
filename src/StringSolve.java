import java.util.Arrays;

/**
 * @author cutiewang
 * @date 2020/3/10 10:27
 */
public class StringSolve {
    public static String moveStringK(String s,int k){
        int pos = s.length()-k;
        char[] c = s.toCharArray();
        reverse(c,0,pos-1);
        reverse(c,pos,s.length()-1);
        reverse(c,0,s.length()-1);
        return new String(c);
    }
    public static void reverse(char[] chars,int i,int j){
        while(i<j){
            char tmp = chars[i];
            chars[i]=chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
    public static String move(String s, int k){
        int pos = s.length()-k;
        return s.substring(pos)+s.substring(0,pos);
    }
    public static String reverseWord(String s){
        String[] word = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            sb.append(word[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s ="abcd123";
        //System.out.println(move(s,3));
        String a = "I AM A STUDENT";
        System.out.println(reverseWord(a));
    }
}
