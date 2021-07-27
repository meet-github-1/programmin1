/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.

NOTE: Always check from righ to left
(Suppose digits positions of 1011 are as follows: 
i.e., digit pos: 3 2 1 0
                 1 0 1 1
check from position 1)


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4
*/
import java.util.*;
import java.util.*;
class hamming{
    static List<Integer> l;
    static Map<String,Boolean> mp;
    static boolean getstrings(StringBuilder sb,int n,int count){
        String sbs=sb.toString();
        if(count==Math.pow(2,n)){
            return true;
        }
        else{
            mp.put(sbs,true);
            for(int i=n-1;i>=0;i--){
                char prev=sb.charAt(i);
                char c=(prev=='0'?'1':'0');
                sb.setCharAt(i,c);
                //System.out.println(sbs+" "+sb.toString());
                if(!mp.getOrDefault(sb.toString(),false)){
                    l.add(Integer.parseInt(sb.toString(),2));
                     boolean val=getstrings(sb,n,count+1);
                     if(val){
                       return true;
                     }
                     l.remove(Integer.parseInt(sb.toString(),2));
                }
                sb.setCharAt(i,prev);
            }
            return false;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String s="";
        for(int i=0;i<n;i++){
            s=s+"0";
        }
        StringBuilder sb=new StringBuilder(s);
        l=new ArrayList<Integer>();
        mp=new HashMap<String,Boolean>();
        l.add(0);
        getstrings(sb,n,1);
        System.out.println(l);
    }
}
