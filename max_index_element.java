/*
Gnanesh Varma is working in a laddus factory.
There are N number of boxes placed in a row, and the boxes are numbered 
from 0,1,2,...,N-1. And you will be asked to find the number fo laddus in 
the box at a given position 'I', in such a way that, the sum of all the laddus 
in all the boxes should be less than 'Total'.

Gnanesh Varma has to fill the laddus in the boxes in the row 
with the following conditions:
	- box[k] is a contains the laddus in the rane of [0, N-1].
	- The diffrence of laddus between two consecutive boxes is
	diff(box[k] - box[k+1]) <= 1 where k is in range of [0, N-1]. 
	- Number of laddus in box[I], should be maximized.

Your task is to help Mr Gnanesh Varma, to maximize the number of laddus in Box-I.
and return the count of laddus in Box-I.

Input Format:
-------------
Three space separated integers, N, I, Total.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5 2 10

Sample Output-1:
----------------
3

Explanation: 
------------
box[] = {1,2,3,2,2} is one such arrangement that follows all the conditions.
another arrangement can be : {1,2,3,2,1}
So, the maximum number of laddus in Box-2 is 3.

Sample Input-2:
---------------
6 4 14

Sample Output-2:
----------------
4
*/
import java.util.*;
import java.lang.*;
class max_index_element{
    static boolean satisfy(int mid,int sm1,int n,int ind){
        long sm=sm1;
        long sum=mid;
        int lft=ind;
        int rgt=n-ind-1;
        if(lft>mid-1){
            sum=sum+(lft-(mid-1));
            int nm=mid-1;
            float dv=(float)nm/2;
            long ap=(long)(dv*(2*(mid-1)+(nm-1)*(-1)));
            sum=sum+ap;
        }
        else{
           float dv=(float)lft/2;
           long ap=(long)(dv*(2*(mid-1)+(lft-1)*(-1)));
           sum=sum+ap;   
        }
        if(rgt>mid-1){
            sum=sum+(rgt-(mid-1));
            int nm1=mid-1;
            float dv1=(float)nm1/2;
            long ap1=(long)(dv1*(2*(mid-1)+(nm1-1)*(-1)));
            sum=sum+ap1;
        }
        else{
            float dv1=(float)rgt/2;
            long ap1=(long)(dv1*(2*(mid-1)+(rgt-1)*(-1)));
            sum=sum+ap1;
        }
        if(sum<=sm){
            return true;
        }
        return false;
    }
    static int get_ind_element(int ind,int n,int sm){
        int st=1;
        int ed=sm;
        int ans=-1;
        while(st<=ed){
            int mid=(st+ed)/2;
            if(satisfy(mid,sm,n,ind)){
                ans=mid;
                st=mid+1;
            }
            else{
                ed=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int ind=in.nextInt();
        int sum=in.nextInt();
        System.out.println(get_ind_element(ind,n,sum));
    }
}
