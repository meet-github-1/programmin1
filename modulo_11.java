import  java.util.*;
import java.lang.*;
class modulo_11{
   public static void main(String[] args){
     Scanner in=new Scanner(System.in);
     String s=in.next();
     int es=0;
     int os=0;
     for(int i=0;i<s.length();i++){
       if(i%2==0){
         es=es+Integer.parseInt(String.valueOf(s.charAt(i)));
       }
       else{
       os=os+Integer.parseInt(String.valueOf(s.charAt(i)));
     }
     }
     int ans=(os-es);
     System.out.println(ans);
     int mod;
     if(ans<0){
        mod=Math.floorMod(ans,11);
     }
     else{
        mod=ans%11;
     }
     System.out.println(mod);
   }
}
