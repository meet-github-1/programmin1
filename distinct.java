import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.*;
class distinct{
    static boolean isvalid(Map<Character,Integer> mp,int k){
        Set<Character> s=mp.keySet();
        for(char c:s){
            if(mp.get(c)==0){
                mp.remove(c);
            }
        }
        return mp.size()<=k;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int n=in.nextInt();
        Map<Character,Integer> mp=new ConcurrentHashMap<Character,Integer>();
        int st=0,ed=0;
        int mxsize=1;
        mp.put(s.charAt(ed),1);
        int len=s.length();
        for(ed=1;ed<len;ed++){
            mp.put(s.charAt(ed),mp.getOrDefault(s.charAt(ed),0)+1);
            while(!isvalid(mp,n)){
                mp.put(s.charAt(st),mp.get(s.charAt(st))-1);
                st++;
            }
            //System.out.println(ed+" "+st);
            if(ed-st+1>mxsize){
                mxsize=ed-st+1;
            }
        }
        System.out.println(mxsize);
    }
}
