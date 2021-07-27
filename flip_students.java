/*
There are N students stands in a row, where girls indicated with 0's 
and boys indicated with 1's. The teacher ask them to stand alternatively 
based on thier gender. [i.e., No two students with same gender stands side by side]

You are allowed to perform these operations to arrange them to sit alternatively:
	Op-1: Move the first student in the row to the end of the row. 
	Op-2: Choose any one position in the row, replace with the student 
	      with another student with opposite enter. 
	      [i.e., replace a boy with girl or a girl with boy]

You will be given the initial sitting of students as a binary string. 
Your task is to find and return the minimum number of Op-2 operations required 
to make them to sit alternatively according to their gender.


Input Format:
-------------
A binary string B.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
1100100

Sample Output-1:
----------------
2

Explanation:
------------
Perform Op-1 operation 3 times: The sitting will be 0100110
Perform Op-2 operation at 4th and 5th positions in the row
Finally, sitting is 0101010


Sample Input-2:
---------------
11011

Sample Output-2:
----------------
1
*/
import java.util.*;
import java.lang.*;
class flip_students{
    static String generate(int len,char c){
        if(len==0){
            return "";
        }
        if(c=='a'){
            StringBuilder sb=new StringBuilder('1');
            boolean flip=false;
            for(int i=0;i<len;i++){
                if(flip){
                    sb.append(1);
                    flip=false;
                }
                else{
                    sb.append(0);
                    flip=true;
                }
            }
            return sb.toString();
        }
        else{
            StringBuilder sb=new StringBuilder('0');
            boolean flip=true;
            for(int i=0;i<len;i++){
                if(flip){
                    sb.append(1);
                    flip=false;
                }
                else{
                    sb.append(0);
                    flip=true;
                }
            }
         return sb.toString();
        }
        
    }
    static int min_op(String s,String a,String b,int ln){
        int ln1=ln/2;
        int mn=9999;
        for(int i=0;i<ln-ln1;i++){
            int ind=0;
            int ac=0;
            int bc=0;
            for(int j=i;j<i+ln1;j++){
                if(s.charAt(j)!=a.charAt(ind)){
                    ac++;
                }
                if(s.charAt(j)!=b.charAt(ind)){
                    bc++;
                }
                ind++;
            }
            mn=Math.min(mn,Math.min(ac,bc));
        }
        return mn;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //x
        String s=in.next();
        int len=s.length();
        String s1=s+s;
        String a=generate(len,'a');
        String b=generate(len,'b');
        System.out.println(min_op(s1,a,b,len*2));
    }
}
