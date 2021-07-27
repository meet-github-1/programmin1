/*
Gunith is interested in series and sequence problems in Maths.
Gunith is given an array A of integers, he wants to find out 
a Sequence, which is long and subsequence of given array.

Subsequence AS is the list AS[i], AS[i1], AS[i2], .... AS[ik], from the array, 
where 0 <= i< i1 < i2 < ..<ik < A.length

The sequence S has to follow this rule, S[i+1] - S[i] are all the same value 
(for 0 <= i < S.length - 1 ), and Sequence S can be formed from A

Find out the Max possible length of the Longest Sequence.

Input Format:
-------------
Line-1 -> An integer N, number of array elements
Line-2 -> N space separated integers, elements of the array.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4
2 6 10 14

Sample Output-1:
----------------
4


Sample Input-2:
---------------
7
2 5 6 8 10 11 14

Sample Output-2:
----------------
5

Explanation:
------------
The longest possible arithmetic series is 2 5 8 11 14.
*/
import java.util.*;
import java.lang.*;
class longsubsequence{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
       int dp[][]=new int[n][100];
       for(int i=0;i<n;i++){
           arr[i]=in.nextInt();
       }
       int max=0;
       for(int i=0;i<n;i++){
           for(int j=i-1;j>=0;j--){
               int diff=arr[i]-arr[j];
               if(diff>0){
                   dp[i][diff]=1+dp[j][diff];
                   max=Math.max(max,dp[i][diff]);
               }
           }
       }
       /*for(int i=0;i<n;i++){
           for(int j=0;j<100;j++){
               System.out.print(dp[i][j]);
           }
           System.out.println();
       }*/
       System.out.println(max+1);
    }
}
