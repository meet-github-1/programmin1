/*
There are N celebrities participated in Go-Green Campaign,
All of them joined together and each one planted a tree on a flat land
at different positions.
 
Now, your task is to find the maximum number of trees in single straight line.

Input Format:
-------------
Line-1 -> An integers N, number of trees planted.
Next N lines -> Two space separated integers, position of the tree.

Output Format:
--------------
Print an integer as result.


Sample Input:
-------------
6
1 1
3 2
5 3
4 1
2 3
1 4

Sample Output:
--------------
4

Explanation:
------------

    Y
    |
    |	"
    | 		"			"
    |			"
    |	"			"	
    ------------------------- X
    0   1   2   3   4   5
*/
import java.util.*;
import java.lang.*;
class dir{
    int x;
    int y;
    int lz;
    int rz;
    dir(int a,int b,int c,int d){
        x=a;
        y=b;
        lz=c;
        rz=d;
    }
    public String toString(){
        return x+"-"+y+"-"+lz+"-"+rz;
    }
}
class stline{
    static dir dp[][];
    static boolean valid(int i,int j){
        return(i>=0 && i<100 && j>=0 && j<100);
    }
    static int gettop(int i,int j){
        i--;
        while(valid(i,j)){
            if(dp[i][j].x!=0){
                return dp[i][j].x;
            }
            i--;
        }
        return 0;
    }
    static int getleft(int i,int j){
        j--;
        while(valid(i,j)){
            if(dp[i][j].y!=0){
                return dp[i][j].y;
            }
            j--;
        }
        return 0;
    }
    static int getlefttop(int i,int j){
        i--;
        j--;
        while(valid(i,j)){
            if(dp[i][j].lz!=0){
                return dp[i][j].lz;
            }
            i--;
            j--;
        }
        return 0;
    }
    static int getrighttop(int i,int j){
        i--;
        j++;
        while(valid(i,j)){
            if(dp[i][j].rz!=0){
                return dp[i][j].rz;
            }
            i--;
            j++;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        dp=new dir[100][100];
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                dp[i][j]=new dir(0,0,0,0);
            }
        }
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            dp[a][b]=new dir(1,1,1,1);
        }
        //meet
        int max=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(dp[i][j].x==1 && dp[i][j].y==1 && dp[i][j].lz==1 && dp[i][j].rz==1){
                    dp[i][j].x=1+gettop(i,j);
                    dp[i][j].y=1+getleft(i,j);
                    dp[i][j].lz=1+getlefttop(i,j);
                    dp[i][j].rz=1+getrighttop(i,j);
                    max=Math.max(max,Math.max(dp[i][j].x,Math.max(dp[i][j].y,Math.max(dp[i][j].lz,dp[i][j].rz))));
                }
            }
        }
        System.out.println(max);
    }
}
