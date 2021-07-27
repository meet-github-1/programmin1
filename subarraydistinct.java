/*
Manoj is given a box full of balls with several colors, 
each colored ball is uniquely identified by a number.

All the balls are arranged in a line randomly.
He is given the arrangement as an array of numbers, colored balls.
He has to form the subarray of size S from left to right, and 
find the number of diffferent colors in each subarray.

Your task is to help Manoj to find the number of different colored balls 
in each subarray and print them as an array.

Input Format:
-------------
Line-1: Two integers N and S, number of balls, size of subarray.
Line-2: N space separated integers, colors of the balls in the line.

Output Format:
--------------
Print an array of integers.


Sample Input-1:
---------------
7 3
2 3 4 3 3 2 4

Sample Output-1:
----------------
[3, 2, 2, 2, 3]


Sample Input-2:
---------------
8 4
1 2 2 2 2 3 4 5

Sample Output-2:
----------------
[2, 1, 2, 3, 4]
*/
import java.util.*;
import java.lang.*;
class subarraydistinct{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int n1=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        if(n<n1){
            System.out.println(0);
            System.exit(1);
        }
        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
        List<Integer> al=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<n1;i++){
            if(mp.getOrDefault(arr[i],0)==0){
                count++;
            }
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        al.add(count);
        for(int i=n1;i<n;i++){
            if(mp.getOrDefault(arr[i-n1],0)==1){
                count--;
            }
            mp.put(arr[i-n1],mp.getOrDefault(arr[i-n1],0)-1);
            if(mp.getOrDefault(arr[i],0)==0){
                count++;
            }
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            al.add(count);
        }
        System.out.println(al);
    }
}
