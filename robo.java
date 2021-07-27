/*
/*
Chitti(ROBO) is busy in turning the people into chittis(ROBOS) by surrounding them.
In a room there are n*n boxes occupied by ROBOS and people.
1.A person will be turned into ROBO if he is surrounded by all ROBOs. 
2.A person will not be turned into ROBO if he is on the edge of the room and all the connected people to him (directly or indirectly) are also not to be turned.
 Return the n*n boxes after conversion.
Input Format:
-------------
Line-1:integer n represent the n*n boxes of the room..
Next n lines:Each line of string consists of combination of 'X'(represents ROBO) and 'O'(represents a person)
 
Output Format:
--------------
Print n*n space seperated values after conversion.


Sample Input-1:
---------------
4
XXXX
XOOX
XXOX
OXXX

Sample Output-1:
----------------
X X X X 
X X X X 
X X X X 
O X X X 

Explanation:
------------
 The people at second row and third row are converted to ROBOs as they are surrounded by ROBOs.
  But the person at fourth row is safe as he is on edge.


Sample Input-2:
---------------
5
XOOOX
XXXXX
XOXXX
XXXOX
OXXXX

Sample Output-2:
----------------
X O O O X 
X X X X X 
X X X X X 
X X X X X 
O X X X X
*/
import java.util.*;
import java.lang.*;
class robo{
    static boolean valid(int i,int j,int n){
        return(i>=0 && j>=0 && i<n && j<n);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char arr[][]=new char[n][n];
        Queue<int[]> q=new LinkedList<int[]>();
        int dir1[]=new int[]{1,0,-1,0};
        int dir2[]= new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<n;j++){
                arr[i][j]=s.charAt(j);
                if(arr[i][j]=='O' && (i==0 || i==n-1 || j==0 || j==n-1)){
                    q.add(new int[]{i,j});
                    arr[i][j]='Q';
                }
                
            }
        }
        while(!q.isEmpty()){
            int ar[]=q.poll();
            for(int i=0;i<4;i++){
                if(valid(ar[0]+dir1[i],ar[1]+dir2[i],n) && arr[ar[0]+dir1[i]][ar[1]+dir2[i]]=='O'){
                    q.add(new int[]{ar[0]+dir1[i],ar[1]+dir2[i]});
                    arr[ar[0]+dir1[i]][ar[1]+dir2[i]]='Q';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='Q'){
                    arr[i][j]='O';
                }
                else{
                    arr[i][j]='X';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
