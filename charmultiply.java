/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words in 
lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
import java.lang.*;
class charmultiply{
    static Set<String> formwords(String s){
        Set<String> t=new TreeSet<String>(); 
        if(s.length()==0){
            return t;
        }
        else{
            if(s.charAt(0)=='['){
                int ind=s.indexOf(']');
                String sub=s.substring(1,ind);
                Set<String> t1=formwords(s.substring(ind+1));
                String arr[]=sub.split(",");
                //System.out.println(Arrays.toString(arr));
                if(t1.size()==0){
                    for(String s1:arr){
                        t.add(s1);
                    }
                }
                else{
                for(String s1:arr){
                    for(String s2:t1){
                        String f=s1+s2;
                        t.add(f);
                    }
                }
                }
                //System.out.println(t);
            }
            else{
                int ind=s.indexOf('[');
                if(ind==-1){
                    ind=s.length();
                }
                String sub=s.substring(0,ind);
                Set<String> t1=formwords(s.substring(ind));
                if(t1.size()==0){
                    t.add(sub);
                }
                else{
                for(String s1:t1){
                    String f=sub+s1;
                    t.add(f);
                }
                }
            }
            return t;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        System.out.println(formwords(s));
    }
}
