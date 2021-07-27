/*
Anup is interested in Word Play, He invented a new game on words
Anup will give you a string S and index P (1-indexed).
You need apply the rules of the game on that string  
and find out the character at a given index P.

Rules are as follows:
1. You have to read one character at a time and keep appending as a word until you find a digit(d).
2. Once you find a digit, the entire word is repeatedly appended d-1 more times in total.

Input Format:
----------------
Line-1 -> A String S
Line-2 -> An integer P, index value.

Output Format:
------------------
Print the result as a String.


Sample Input-1:
-------------------
kmit2ngit3
12

Sample Output-1:
---------------------
t

Explanation-1:
----------------
The resultant string is "kmitkmitngitkmitkmitngitkmitkmitngit".
The 12th character in the string is "t".

Sample Input-2:
-------------------
ab3c4
9

Sample Output-2:
---------------------
b

Explanation-2:
----------------
The resultant string is "abababcabababcabababcabababc"
The 9th character in the string is "b".
*/
import java.util.*;
import java.lang.*;
class stringrepeat{
    static String repeat(String r,int num){
        String r1="";
        //System.out.println(num);
        for(int i=0;i<num;i++){
            r1=r1+r;
        }
        return r1;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int ind=in.nextInt();
        int len=s.length();
        String r="";
        for(int i=0;i<len;i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                r=repeat(r,Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            else{
                r=r+s.charAt(i);
            }
        }
        System.out.println(r.charAt(ind-1));
    }
}
