/*
Ganesh is working on numbers,
He is given a list of integers 1,2,3,...,N, the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want.
Shuffled list is said to be valid, if one of the following is true for 
i-th position in the list.
	- The integer at the i-th position is divisible by i.
	- 'i' is divisible by the integer at the i-th position.

Now your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input:
---------------
2

Sample Output:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
*/
import java.util.*;
import java.lang.*;
class arrayfill{
    static boolean vis[];
    static boolean isdivisible(int num1,int num2){
        return num1%num2==0||num2%num1==0;
    }
    static int numofways(int n,int arr[],int ind){
        if(ind==n+1){
            return 1;
        }
        else{
            int count=0;
            for(int i=n;i>0;i--){
                if(isdivisible(i,ind) && !vis[i]){
                    arr[ind]=i;
                    vis[i]=true;
                    count+=numofways(n,arr,ind+1);
                    arr[ind]=0;
                    vis[i]=false;
                }
            }
           
            return count;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n+1];
        vis=new boolean[n+1];
        System.out.println(numofways(n,arr,1));

    }
}
