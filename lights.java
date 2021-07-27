/*
There is a road in a hill area, the road is flat in some places and slope 
in some places (only upwards). There are N lamp posts are fixed on one side 
of the road. The lights on the lamp posts are arranged in horizontal line, 
for making this arrangement, the lamp post are made with different heights.

You will be given the heights of the lamp posts from top of the hill to 
the bottom of the hill. And you will be given an height H, your task is to find 
the starting and ending position of the lamp posts with height H. 
If there is no such lamp post with height H, return [-1, -1].

Complete your code with O(log n) runtime complexity.

Input Format:
-------------
Line-1 -> Two space separated integers N and H, number of lamp posts and height H.
Line-2 -> N space separated integers, heights of the lamp posts.

Output Format:
--------------
Print two integers set, starting and ending positions of the lamp posts with height H.


Sample Input-1:
---------------
10 5
2 3 3 5 5 5 8 9 9 9

Sample Output-1:
----------------
[3, 5]


Sample Input-2:
---------------
10 6
2 3 3 5 5 5 8 9 9 9

Sample Output-2:
----------------
[-1, -1]
*/
import java.util.*;
import java.lang.*; 
class lights{
    static List<Integer> li;
    static void binarysearch(int arr[],int n,int l,int h,int key){
        if(l>h){
            return ;
        }
        else{
            int mid=(l+h)/2;
            if((mid==0 && arr[mid]==key)|| (mid==n-1 && arr[mid]==key)|| (mid>0 && mid<n-1 && arr[mid-1]!=key && arr[mid]==key && arr[mid+1]!=key))
            {
                li.set(0,mid);
                li.set(1,mid);
            }
            else if((mid==0 && arr[mid]==key) || (mid>0 && (arr[mid]==key && arr[mid-1]!=key))){
                li.set(0,mid);
                binarysearch(arr,n,mid+1,h,key);
                return;
            }
            else if((mid==n-1 && arr[mid]==key) || (mid<n-1 && (arr[mid]==key && arr[mid+1]!=key))){
                li.set(1,mid);
                binarysearch(arr,n,l,mid-1,key);
                return;
            }
            else{
                if(arr[mid]<key){
                binarysearch(arr,n,mid+1,h,key);
                return;
                }
                else if(arr[mid]>key){
                binarysearch(arr,n,l,mid-1,key);
                return;
                }
                else{
                    binarysearch(arr,n,mid+1,h,key);
                    binarysearch(arr,n,l,mid-1,key);
                    return;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int H=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        li=new ArrayList<Integer>();
        li.add(-1);
        li.add(-1);
        binarysearch(arr,n,0,n-1,H);
        System.out.println(li);
    }
}
