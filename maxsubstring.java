import java.util.*;
import java.lang.*;
class maxsubstring{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        char arr[]=s.toCharArray();
        char mx='a';
        int i=0;
        for(char c:arr){
            if(c>mx){
                mx=c;
            }
            i++;
        }
        String max="";
        i=0;
        for(char c:arr){
            if(c==mx){
                String sub=s.substring(i);
                max=sub.compareTo(max)>0?sub:max;
            }
            i++;
        }
        System.out.println(max);
    }
}
