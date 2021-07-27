/*
Pramod is working on Strings consist of digits only. 
He wants to findout, whether the given string can form Fibonacci sequence or not.

A String can form a Fibonacci Sequence, if it contains at least three numbers,
and numbers are in the following order:
first, second, third  = first + second, fourth = third + second, .. so on.

Return true, if the given string can form fibonacci sequence,
otherwise, return false.

Note: Numbers in the fibonacci sequence contains no leading 0's.
for example, 2, 03,5 or 2,3,05 or 02,3,5 are not valid.

Input Format:
-------------
A String consist of digits only

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
23581321

Sample Output-1:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 2, 3, 5, 8, 13, 21
2, 3, 2+3=5, 3+5=8, 5+8=13, 8+13=21.

Sample Input-2:
---------------
199100199

Sample Output-2:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 1 99 100 199
1, 99, 1+99=100, 99+100=199.
*/
import java.util.*;
import java.lang.*;
class fibbo{
    static boolean isfibbo(String s){
        int n1=0;
       for(int i=0;i<s.length()/2;i++){
           n1=n1*10+(s.charAt(i)-'0');
           int n2=0;
           for(int j=i+1;j<s.length()-Math.max(i,j-i);j++){
               n2=n2*10+(s.charAt(j)-'0');
               if(fibbocheck(n1,n2,s)){
                   return true;
               }
           }
       }
       return false;
    }
    static boolean fibbocheck(int num1,int num2,String s){
        StringBuilder sb1=new StringBuilder();
        sb1.append(num1);
        sb1.append(num2);
        while(s.length()>sb1.length()){
            int t=num1+num2;
            sb1.append(t);
            num1=num2;
            num2=t;
        }
        return sb1.toString().equals(s);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        //p
        System.out.println(isfibbo(s));
    }
}
