/*
Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.
*/
import java.util.*;
import java.lang.*;
class unique_div{
    static int max;
    static void get_max(String s,Set<String> st){
        if(s.length()==0){
            max=Math.max(max,st.size());
            return;
        }
        else{
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
                //System.out.println(sb.toString()+" "+s.substring(i+1));
                if(st.add(sb.toString())){
                    get_max(s.substring(i+1),st);
                    st.remove(sb.toString());
                }
            }
            return;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //p
        String s=in.next();
        max=0;
        get_max(s,new HashSet<String>());
        System.out.println(max);
    }
}
