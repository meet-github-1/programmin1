/*
Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub


Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.


Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.


Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0
*/
import java.util.*;
import java.lang.*;
class rabinkarp{
    static int freq(String s,int mid,int len){
        if(mid==0){
            return 0;
        }
        Map<String,Integer> smp=new LinkedHashMap<String,Integer>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<mid;i++){
            sb.append(s.charAt(i));
        }
        smp.put(s.substring(0,mid),1);
        for(int i=mid;i<len;i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            smp.put(sb.toString(),smp.getOrDefault(sb.toString(),0)+1);
        }
         int fr=Collections.max(smp.values());
         return fr;
    }
    static int maxlength(String s,int len){
        int st=0;
        int ed=len-1;
        int prevlen=0;
        while(st<=ed){
            int mid=(st+ed)/2;
            int fr=freq(s,mid,len);
            if(fr>=2){
                st=mid+1;
                prevlen=mid;
            }
            else{
                ed=mid-1;
            }
            
        }
        return prevlen;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int len=s.length();
        System.out.println(maxlength(s,len));
    }
}
