/*
Viraj Aanand is a wedding planner, He order his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes,  1 1  and 1 1  are different.           1          
*/
import java.util.*;
import java.lang.*;
class planner{
    static boolean vis[][];
    static int dir1[];
    static int dir2[]; 
    static boolean valid(int i,int j,int r,int c){
        return (i>=0 && i<r && j>=0 && j<c);
    }
    static String getdir(int i,int j){
        if(i==0 && j==1){
            return "r";
        }
        else if(i==1 && j==0){
            return "d";
        }
        else if(i==0 && j==-1){
            return "l";
        }
        else {
            return "u";
        }
    }
    static String getopp(String dir){
        switch(dir){
            case "u":
                return "d";
            case "d":
                return "u";
            case "r":
                return "l";
            case "l":
                return "r";
        }
        return "";
    }
    static String dfs(int x,int y,int arr[][],int r,int c){
            vis[x][y]=true;
            String s="";
            for(int i=0;i<4;i++){
                if(valid(x+dir1[i],y+dir2[i],r,c) && !vis[x+dir1[i]][y+dir2[i]] && arr[x+dir1[i]][y+dir2[i]]==1){
                    String dir=getdir(dir1[i],dir2[i])+dfs(x+dir1[i],y+dir2[i],arr,r,c);
                    s=s+dir;
                    s=s+getopp(dir);
                }
            }
            return s;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int r=in.nextInt();
        int c=in.nextInt();
        int arr[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=in.nextInt();
            }
        }
        vis=new boolean[r][c];
        Set<String> st=new HashSet<String>(); 
        dir1=new int[]{1,0,-1,0};
        dir2=new int[]{0,1,0,-1};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!vis[i][j] && arr[i][j]==1){
                    String patt=dfs(i,j,arr,r,c);
                    //System.out.println(patt);
                    st.add(patt);
                }
            }
        }
        System.out.println(st.size());
    }
}
