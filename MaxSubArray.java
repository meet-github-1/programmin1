/*
Given a set of N batteries with some voltages[], the voltage can be '+ve' or '-ve',
and you need to setup a perticular voltage V.

Your task is to check if the sum of voltages of contiguous subset of batteries
is equal to the required voltage V and the batteries in the subset should be 
maximum in count. If such subset is found print the count of batteries in it.
Otherwise, print 0.

Input Format:
-------------
Line-1 : Two integers N and V, number of batteries and required voltage.
Line-2 : N space separated integers, voltages of N batteries.

Output Format:
--------------
Print an integer, maximum count of batteries in a contiguous subset 
whose voltages sum is equal to V.


Sample Input-1:
---------------
5 3
2 -2 7 -4 3

Sample Output-1:
----------------
4

Explanation:
--------------
The sum of contiguous subset of batteries with volates: [2, -2, 7, -4] is equals 3.
and it is the maximum.

Sample Input-2:
---------------
4 2
-5 -3 5 3

Sample Output-2:
----------------
2

Explanation: 
------------
The sum of contiguous subset of batteries with volates: [-3, 5] is equals 2.
and it is the maximum.
*/
import java.util.*;
import java.lang.*;
public class MaxSubArray{
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);
        }
        return max;
    }
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int arr[]=new int[n]; 
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println(new MaxSubArray().maxSubArrayLen(arr,k));
	}
}
