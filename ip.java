import java.util.*;
import java.lang.*;
class ip{
    static List<String> l;
    static boolean validip(String s){
        //System.out.println(s);
        int ln=s.length();
        String s1="";
        int count=0;
        for(int i=0;i<ln;i++){
            if(s.charAt(i)=='.'){
                int len=s1.length();
                int num=Integer.parseInt(s1);
                if(num<0 || num>255 || len>3 || (s1.charAt(0)=='0' && len>1)){
                    return false;
                }
                s1="";
                count++;
                continue;
            }
            s1=s1+s.charAt(i);
        }//r
        int len=s1.length();
        int num=Integer.parseInt(s1);
        if(num<0 || num>255 ||  len>3 || (s1.charAt(0)=='0' && len>1)){
            return false;
        }
        if(count<3){
            return false;
        }
        return true;
    }
    static void formip(StringBuilder sb,int ind,int len,int count){
        if(count==3){
          String s=sb.toString();
          //System.out.println(s);rp
          if(validip(s)){
              l.add(s);
          } 
        }
        else{
            for(int i=1;i<=3;i++){
                //System.out.println(i);
                if(ind+i<len){
                    sb.insert(ind+i,'.');
                    //System.out.println(sb.toString()+" "+(ind+i)+" "+i);
                    formip(sb,ind+i+1,len+1,count+1);
                    sb.deleteCharAt(ind+i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        StringBuilder sb=new StringBuilder(s);
        l=new ArrayList<String>();
        formip(sb,0,s.length(),0);
        System.out.println(l);
    }
}
