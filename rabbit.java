/*
There is a fresh veggies farm on top of a hill,
The farmer has built a 3-colored steps to reach his farm on top of the hill.
There are 3-lanes from ground to the hill top, i.e., each color will represent a lane.
There are N steps, and step-0 is the ground, and step-n is the top of the hill.

There is a rabbit in search of fresh veggies to eat, and knows about the farm 
on top of the hill. The rabbit starts to climb the steps in the middle lane 
from step-0, one after the other. There are few gates arranged on each lane and 
the gates are locked. If the rabbit found a gate on the next step, it has to move 
to the adjacent lane of the same step, and if the adjacent lane also has a gate 
on same step, the rabbit can jump over the gate to reach the lane which is not 
adjacent. There will be at most one gate on each step.

The rabbit cannot jump over the gate on the next step.

You will be given positions of the gates as gates[] array of size N+1,
Your task is to find out the minimum number of jump overs, 
the rabbit needs to reach step-n the top of the hill in any lane starting from middle lane to step-0. 

NOTE:
	- gates[a]=b means there is a gate in lane-b, on step-a.
	- gates[3]=2 means there is a gate in lane-2, on step-3.
	- gates[2]=0 means there is no gate on step-2.
	- there are no gates on step-0 and step-n.
	
Input Format:
-------------
Line-1: An integer N, number of steps built.
Line-2: N+1 space separated integers, gates[i] is between [0-3]

Output Format:
--------------
Print an integer, minimum number of jump overs.


Sample Input-1:
---------------
5
0 2 1 3 3 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
0 3 1 1 3 0

Sample Output-2:
----------------
0
*/
import java.util.*;
import java.lang.*;
class rabbit{
    static int MAX=99999999;
    static int dp[][];
    static boolean valid(int r,int c,int i,int j){
        return(i>=0 && i<r && j>=0 && j<c);
    }
    static int minsteps(int arr[][],int r,int c,int i,int j){
        if(i==r){
            return 0;
        }
        else if(!valid(r,c,i,j)){
            return MAX;
        }
        else if(arr[i][j]==1){
            return MAX;
        }
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else{
            if(arr[i+1][j]==1){
                int y1=(j==0)?2:j-1;
                int y2=(j==2)?0:j+1;
                //System.out.println(i+" "+y1+","+i+" "+y2);
                dp[i][j]=1+Math.min(minsteps(arr,r,c,i,y1),minsteps(arr,r,c,i,y2));
            }
            else{
                //System.out.println(i+1+" "+j);
                dp[i][j]= minsteps(arr,r,c,i+1,j);
            }
            return dp[i][j];
        }
        
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int ar[][]=new int[n+1][3];
        int arr[]=new int[n+1];
        dp=new int[n+1][3];
        for(int i=0;i<=n;i++){
            arr[i]=in.nextInt();
            if(arr[i]!=0){
                ar[i][arr[i]-1]=1;
            }
            for(int j=0;j<3;j++){
                dp[i][j]=-1;
            }
        }
        /*for(int i=0;i<=n;i++){
            for(int j=0;j<3;j++){
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.println(minsteps(ar,n,3,0,1));
        /*for(int i=0;i<=n;i++){
            for(int j=0;j<3;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        
    }
}
