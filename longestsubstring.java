import java.util.*;
import java.lang.*;
class longestsubstring{
    static int findlongest(String s,int k){
        int len=s.length();
        if(len==0 || len<k) return 0;
        if(k<=1) return len;
        Map<Character,Integer> mp=new HashMap<Character,Integer>();
        for(int i=0;i<len;i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        int l=0;
        while(l<len && mp.get(s.charAt(l))>=k){
            l++;
        }
        if(l>=len){
            return l;
        }
        int l1=findlongest(s.substring(0,l),k);
        while(l<len && mp.get(s.charAt(l))<k){
            l++;
        }
        int l2=findlongest(s.substring(l,len),k);
        //p
        return Math.max(l1,l2);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int k=in.nextInt();
        System.out.println(findlongest(s,k));
    }
}
