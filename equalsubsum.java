/*
Bharath is given a set of integers arr[] of length N.
He planned split arr[] into four subsets.

He also defined a rule set to split the set arr[] as follows:
	- select three indices p, q, r, where p < q < r.
	- split the arr[] as four subsets: sub(0, p-1), sub(p+1, q-1) sub(q+1, r-1), sub(r+1, N-1)
	- the sum of elements in each subset should be equal .
	  i.e., subsum(0, p-1) = subsum(p+1, q-1) = subsum(q+1, r-1) = subsum(r+1, N-1)

Your task is to help Bharath to split the set arr[] with the above rules,
If you are able to satisfy all the rules , return true. Otherwise, false.


Input Format:
-------------
Line-1 -> An integer N, number of array elements
Line-2 -> N space separated integers, elements of the array.

Output Format:
--------------
Print an boolean result.


Sample Input-1:
---------------
10
2 6 1 7 2 7 8 7 7 0

Sample Output-1:
----------------
false


Sample Input-2:
---------------
10
3 3 4 1 5 4 2 4 5 6

Sample Output-2:
----------------
true

Explanation:
--------------
p = 2, q = 5, r = 8.
subsum(0, i - 1) = subsum(0, 1) = 6
subsum(i + 1, j - 1) = subsum(3, 4) = 6
subsum(j + 1, k - 1) = subsum(6, 7) = 6
subsum(k + 1, n - 1) = subsum(9) = 6
*/
import java.util.*;
import java.lang.*;
class equalsubsum{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int prefixsum[]=new int[n];
        prefixsum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixsum[i]=arr[i]+prefixsum[i-1];
        }
        Set<Integer> st1;
        Set<Integer> st2;
        boolean flag=false;
        for(int i=3;i<n-2;i++){
            st1=new HashSet<Integer>();
            st2=new HashSet<Integer>();
            for(int j=1;j<i;j++){
                int sum1=prefixsum[j-1];
                int sum2=prefixsum[i-1]-prefixsum[j];
                //System.out.println(sum1+" "+sum2);
                if(sum1==sum2){
                    st1.add(sum1);
                }
            }
            for(int k=i+1;k<n;k++){
                int sum1=prefixsum[k-1]-prefixsum[i];
                int sum2=prefixsum[n-1]-prefixsum[k];
                //System.out.println(sum1+" "+sum2);
                if(sum1==sum2){
                    st2.add(sum1);
                }
            }
           st1.retainAll(st2);
           if(st1.size()!=0){
               flag=true;
               break;
           }
        }
        System.out.println(flag);
    }
}
