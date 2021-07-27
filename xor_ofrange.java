/*
Subramanya sastri is good in solving the problems on numerics.
He is given two numbers start and end, where two values indicates a range.
The problem to solve by Mr Sastri is to perform the biwise AND operation
on all natural numbers between start and end and return the value.

Your task is to help Mr.Sastri to find the final result.
 
Note: Both start and end values are positive numbers.

Input Format:
-------------
Two space separated integers, Start and End.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
12 15

Sample Output-1:
----------------
12


Sample Input-2:
---------------
7 11

Sample Output-2:
----------------
0
*/
import java.util.*;
import java.lang.*;
class xor_ofrange{
    static int find_msb(long num){
        int msb=-1;
        //System.out.println("num"+" "+num);
        while(num>0){
            num=num>>1;
            //System.out.println(num);
            msb++;
        }
        return msb;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        long l=in.nextInt();
        long r=in.nextInt();
        long res=0;
       while(l>0 && r>0){
           int msb1=find_msb(l);
           int msb2=find_msb(r);
           if(msb1!=msb2){
               break;
           }
           long msb=1<<msb1;
           res=res+msb;
           l=l-msb;
           r=r-msb;
       }
       System.out.println(res);
    }
}
