/*
Now a days, everyone is used type the words using short-forms,
A short-form can be created by replacing non-intersected substrings 
with their respective lengths.

e.g., elite can be written as follows:
    - e3e (by replacing lut with 3), 
    - el2e (by replacing it with 2), 
    - 3t1 (by replacing eli and e with 3 and 1).
etc.


You will be given a word.
Your task is to find all possible short-fomrs of the given word, 
and print them as a list of lexicographic order.


Input Format:
-------------
A string W, the word.

Output Format:
--------------
Print the list of possible short-forms of W in lexographic order. 


Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[4, 3t, 2i1, 2it, 1m2, 1m1t, 1mi1, 1mit, k3, k2t, k1i1, k1it, km2, km1t, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[3, 2e, 1s1, 1se, c2, c1e, cs1, cse]
*/
import java.util.*;
import java.lang.*;
class shortform{
    static List<String> l;
    static String formstring(StringBuilder s,int len){
        int prev=0;
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='1'){
                if(prev>0){
                    sb1.append(prev);
                }
                sb1.append(s.charAt(i));
                prev=0;
            }
            else{
                prev++;
            }
        }
        if(prev>0){
            sb1.append(prev);
        }
        return sb1.toString();
    }
    static void shortform(StringBuilder sb,int ind,int len){
        if(ind==len){
            String s=formstring(sb,len);
            l.add(s);
        }
        else{
            shortform(sb,ind+1,len);
            char prev=sb.charAt(ind);
            sb.setCharAt(ind,'1');
            shortform(sb,ind+1,len);
            sb.setCharAt(ind,prev);
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        l=new ArrayList<String>();
        shortform(new StringBuilder(s),0,s.length());
        //System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
    }
}
