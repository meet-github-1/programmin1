/*
Cardano is a famous mathematician. working on numbers.
Given a number N, which is the product of all the digits of a number.
You need to find such smallest number S.

Your task is to help Mr Cardano to find smallest number S, 
where the product of all the digits of S should be equal to N.
If it is not possible to create S with in range of integer, print 0.


Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer, smallest number S.


Sample Input-1:
---------------
36

Sample Output-1:
----------------
49


Sample Input-2:
---------------
147

Sample Output-2:
----------------
377


Sample Input-3:
---------------
22

Sample Output-3:
----------------
0
*/
import java.util.*;
import java.lang.*;
class numberproduct{
    static long min=Long.MAX_VALUE;
    static void findnumber(Long num,String s){
        //System.out.println(num);
        if(num<=0){
            return;
        }
        if(num==1){
            min=Math.min(min,Long.parseLong(s));
            return;
        }
        else{
            for(int i=2;i<=9;i++){
                if(num%i==0){
                  findnumber(num/i,s+i);
                }
              }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Long n=in.nextLong();
        findnumber(n,"");
        System.out.println(min==Long.MAX_VALUE?0:min);
    }
}
