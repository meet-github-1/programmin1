/*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s. And String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.

Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"
*/
import java.util.*;
import java.lang.*;
class relativestring{
    static void union(char c1,char c2,char par[]){
        char p1=find(c1,par);
        char p2=find(c2,par);
        if(p1<p2){
            par[p2-97]=p1;
        }
        else{
            par[p1-97]=p2;
        }
    }
    static char find(char c,char par[]){
        //System.out.println(c);
        //System.out.println(c-97);
        if(par[c-97]!=c){
            return par[c-97]=find(par[c-97],par);
        }
        return c;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arr[]=in.nextLine().split(" ");
        char parent[]=new char[26];
        for(int i=0;i<26;i++){
            parent[i]=(char)(97+i);
        }
        int len=arr[0].length();
        for(int i=0;i<len;i++){
            union(arr[0].charAt(i),arr[1].charAt(i),parent);
        }
        String out="";
        for(int i=0;i<arr[2].length();i++){
            char p=find(arr[2].charAt(i),parent);
            out=out+p;
        }
        System.out.println(out);
    }
}
