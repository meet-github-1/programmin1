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
class max_index_element1{
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),ind=sc.nextInt(),t=sc.nextInt();
		int af=n-ind-1,s=1,e=t,ans=-1;
		while(s<=e){
			int m=(s+e)/2,b=0,a=0;
			for(int i=0;i<Math.max(ind,af) && b+a+m<=t;i++){
				if(i<ind){
				    if(m-i-1<=0)    b++;
				    else    b+=m-i-1;
				}
				if(i<af){
				    if(m-i-1<=0)    a++;
				    else   a+=m-i-1;
				}
			}
			if(b+a+m<=t){
				ans=m;
				s=m+1;
			}
			else e=m-1;
		}
		System.out.println(ans);
    }
    }
