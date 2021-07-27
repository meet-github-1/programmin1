/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]
*/
import java.util.*;
import java.lang.*;
class climbingnumber{
    static List<Integer> li;
    static void getnumbers(int num,int digit,int l,int h){
        if(num>h){
            return;
        }
        else{
            if(num>=l){
                li.add(num);
            }//p
            if(digit<9){
            getnumbers((num*10+(digit+1)),digit+1,l,h);
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int l=in.nextInt();
        int h=in.nextInt();
        li=new ArrayList<Integer>();
        for(int i=1;i<9;i++){
            getnumbers(i,i,l,h);
        }
        Collections.sort(li);
        System.out.println(li);
    }
}
