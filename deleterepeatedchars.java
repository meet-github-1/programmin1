/*
Somayajaulu working with strings.
He is given a string S, string S contains repeated characters.
Somayajulu decided to delete all the repeated characters, 
such that each character in S should appears once and only once.
He is deleting the characters from S in such a way that, 
the final string should be the smallest string among all possibilities

You are given the string S.
Your task is to help Somayajulu to find the smallest string possible 
after deleting the repeated characters from S.

Input Format:
-------------
A string S.

Output Format:
--------------
Print a string, smallest string after deleting repeated characters.


Sample Input-1:
---------------
attitude

Sample Output-1:
----------------
aitude


Sample Input-2:
---------------
cbabacbabca

Sample Output-2:
----------------
abc
*/
import java.util.*;
import java.lang.*;
class deleterepeatedchars{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        Map<Character,Integer> mp=new HashMap<Character,Integer>();
        Stack<Character> st=new Stack<Character>();
        int len=s.length();
        for(int i=0;i<len;i++){
            mp.put(s.charAt(i),i);
        }
        for(int i=0;i<len;i++){
            if(st.contains(s.charAt(i))){
                continue;
            }
            while(!st.isEmpty() && (st.peek()>s.charAt(i) && mp.get(st.peek())>i)){
                st.pop();
            }
            st.push(s.charAt(i));
            //System.out.println(st);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
