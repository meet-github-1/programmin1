/*
Sukumar is a mathematics teacher.
Sukumar is always intersted to create logical problems.
He has given a problem to the students to solve it.
Students are given sentence with set of words, students has to find two words
W1 and W2, such that there should be no common letters between W1 and W2, 
and return the product of W1.length and W2.length.
If there are no such words in the sentence return 0.

Your task is to solve the problem given by Sukumar and help the students.

Input Format:
-------------
Space separated strings, the sentence with set of words[].

Output Format:
--------------
Print an integer, maximum product of two max length words.


Sample Input-1:
---------------
there is an wondeful event going to happen in the school

Sample Output-1:
----------------
30

Explanation: 
------------
The two words will be "there", "school".
or "going", "happen"..etc


Sample Input-2:
---------------
elegant jewels are made here

Sample Output-2:
----------------
0

Explanation: 
------------
All words have atleast one letter in common.
*/
import java.util.*;
import java.lang.*;
class different_string{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arr[]=in.nextLine().split(" ");
        int sz=arr.length;
        int lent[]=new int[sz];
        int bits[]=new int[sz];
        int i=0;
        //p
        for(String s:arr){
            int len=s.length();
            lent[i]=len;
            int bit=0;
            for(char c:s.toCharArray()){
                bit=bit|1<<(int)(c-'a');
            }
            bits[i]=bit;
            i++;
        }
        int max=0;
        for(i=0;i<sz-1;i++){
            for(int j=i+1;j<sz;j++){
                if((bits[i] & bits[j])==0){
                    max=Math.max(max,lent[i]*lent[j]);
                }
            }
        }
        System.out.println(max);
    }
}
