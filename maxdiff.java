/*
Shaggy Rogers is working with numbers.
He is given a number N, 
He wants to replace all occurrences of a digit in the number N,
with another digit between [0-9]. May be with same number too.

But there should not be any leading zeros in the number after the replacement,
Or the number should not become zero.

Rogers can perform the replacement of the occurrences of the digit in N for two 
times, He will generate two new numbers P and Q, such that the value of |P-Q| 
should be Maximum.

Your task is to help Shaggy Roers to find the maximum difference of P and Q possible.


Input Format:
-------------
An integer N, the number

Output Format:
--------------
Print an integer, the maximum difference of P and Q


Sample Input-1:
---------------
123

Sample Output-1:
----------------
820

Explanation:
------------
Replacement-1: replace 1 with 9 you will get P as 923
Replacement-2: replace 2 with 0 you will get Q as 103
So Max difference is 820.


Sample Input-2:
---------------
4254

Sample Output-2:
----------------
8008

Explanation:
------------
Replacement-1: replace 4 with 9 you will get P as 9259
Replacement-2: replace 4 with 1 you will get Q as 1259
So Max difference is 8008.
*/
import java.util.*;
import java.lang.*;
class maxdiff{
    static char findmr(String s,int len){
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='9'){
                return s.charAt(i);
            }
        }
        return 'z';
    }
    static char findsr(String s,int len){
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='1'){
                return s.charAt(i);
            }
        }
        return 'a';
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int len=s.length();
        StringBuilder sb1=new StringBuilder(s);
        StringBuilder sb2=new StringBuilder(s);
        char mrp=findmr(s,len);
        char srp=findsr(s,len);
        if(mrp!='z'){
            for(int i=0;i<len;i++){
                if(s.charAt(i)==mrp){
                    sb1.setCharAt(i,'9');
                    
                }
                
            }
        }
        if(srp!='a'){
            for(int i=0;i<len;i++){
                if(s.charAt(0)=='1' && s.charAt(i)==srp){
                    sb2.setCharAt(i,'0');
                    
                }
                else if(s.charAt(i)==srp){
                    sb2.setCharAt(i,'1');
                    
                }
                
            }
        }
        //System.out.println(sb1.toString()+" "+sb2.toString());
        System.out.println(Integer.parseInt(sb1.toString())-Integer.parseInt(sb2.toString()));
    }
}
