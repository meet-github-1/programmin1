/*
Bunny is playing with binary strings.
He wants to break a binary string B into 3 parts, of length atleast '1',
when we merge the 3 parts will result the string B.

Your task is to find the number of ways to break the Binary String B 
into 3 parts, where each part should contain equal number of 1's.
The answer may be too large, return it modulo 10^9 + 7.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, number of ways to split.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six ways to break S into 3 parts 
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0


******* Testcases *******
case =1
input =01010010
output =6

case =2
input =010010
output =0

case =3
input =100100010100110
output =12

case =4
input =111111111111111
output =1

case =5
input =010010010000001010010000010011000
output =42

case =6
input =01010100010100000010001010100100000000010010101010
output =70

case =7
input =01010100010000000100010101000000000001001010100
output =96

case =8
input =010100001000000010001001000000000000010101000000000000000000000000000000001010000100000001000100100000000000001010100000000000000000000000000000000000000000000010100001000000010001001000000000000010101
output =1518
*/
import java.util.*;
import java.lang.*;
class binarystring{
    static int one;
    static int countdivide(String s,int div,int st){
        if(div==2){
            return 1;
        }
        else{
            int ocount=0;
            while(ocount!=one/3){
                if(s.charAt(st)=='1'){
                    ocount++;
                }
                st++;
            }
            //System.out.println(div+" "+st);
            int count=0;
            while(s.charAt(st)!='1'){
                int num=countdivide(s,div+1,st);
                count+=num;
                st++;
                //System.out.println(num);
            }
            count+=countdivide(s,div+1,st);
            return count;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int len=s.length();
        one=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        if(one%3!=0){
            System.out.println(0);
        }
        else{
        System.out.println(countdivide(s,0,0));
        }
    }
}

