import java.util.*;
import java.lang.*;
class scs{
    static int lcs(String s1,String s2){
         int l1=s1.length();
         int l2=s2.length();
         int ls[][]=new int[l1+1][l2+1];
         for(int i=0;i<=l1;i++){
           for(int j=0;j<=l2;j++){
               if(i==0 || j==0) ls[i][j]=0;
               else{
                   if(s1.charAt(i-1)==s2.charAt(j-1))ls[i][j]=ls[i-1][j-1]+1;
                   else ls[i][j]=Math.max(ls[i-1][j],ls[i][j-1]);}
               }
           }
         return ls[l1][l2];
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();
        System.out.println(s1.length()+s2.length()-lcs(s1,s2));
    }
}
