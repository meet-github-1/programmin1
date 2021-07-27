/*
There is a row of buildings constructed by Raj Group Ltd.

The civil engineer planned to construct the buildings in ascending order 
of their heights, but there is a group of contiguous buildings not constructed according 
to the plan, remove such group of buildings from that row of buildings (can be empty), 
so that the buildings in the row are in ascending order of their heights.

Your task is to find and return the number of buildings in such group.

Input Format:
-------------
Line-1: An integer N, length of array.
Line-2: N space separated integers, heights of the buildings.

Output Format:
--------------
Print an integer, the minimum of group of buildings.


Sample Input-1:
---------------
8
2 3 5 12 2 4 5 7

Sample Output-1:
----------------
3

Explanation:
------------
The minimum group of builings in a row, you can remove is [5, 12, 2] or  [12, 2, 4]  of length 3. 
the remaining buildings with the heights after removal will be [2, 3, 4, 5, 7], or 
the remaining buildings with the heights after removal will be [2, 3, 5, 5, 7], which are sorted.


Sample Input-2:
---------------
6
9 7 5 4 2 1

Sample Output-2:
----------------
5

Explanation:
------------
The minimum group of builings in a row, you can remove is [7, 5, 4, 2, 1] or  
[9, 7, 5, 4, 2]  of length 5. 
*/
import java.util.*;
import java.lang.*;
class rajgroup{
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while(left + 1 < arr.length && arr[left] <= arr[left+1]) left++;
        if(left == arr.length - 1) return 0;
        
        int right = arr.length - 1;
        while(right > left && arr[right-1] <= arr[right]) right--;
        int result = Math.min(arr.length - left - 1, right);
        
        int i = 0;
        int j = right;
        while(i <= left && j < arr.length) {
            if(arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            }else {
                j++;
            }   
        }
        return result;
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int array[]=new int[N];
		
		for(int i=0;i<N;i++)
			array[i]=sc.nextInt();

		System.out.print(new ShortestSubarray().findLengthOfShortestSubarray(array));
	}
}
