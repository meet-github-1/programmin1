/*
Pandavas and Kauravas are ruling two different kingdoms sepertaed by river.
If you connect both the kingdoms they will be in Square shaped land.
Land occupied by the kingdoms, indiacted with 1's and the river, indiacted with 0's.

Now, Pandavas and Kauravas decided to build a bridge on the river for easy 
connectivity. As the cost of building a bridge will be high, they have decided 
to reduce the length of the bridge. You are allowed to build the bridge on 
the river cells, connected by 4 directions only (up, down,left,right).

Your task is to help the Kings, to minimize the occupation of river cells, 
to build the bridge with minimum cost. And return the count of river cells occupied.

Input Format:
-------------
Line-1: An integer N, size of the land.
Next N lines: N space separated integers, either 0 or 1. 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
1 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5
1 1 0 0 0
1 1 0 0 0
0 0 0 0 1
0 0 0 1 1
0 0 1 1 1

Sample Output-2:
----------------
3
*/
import java.util.*;
import java.lang.*;
import javafx.util.Pair;
class bridge{
    static Queue<Pair<Integer,Integer>> q1;
    static Queue<Pair<Integer,Integer>> q2;
    static Queue<Pair<Integer,Integer>> q3;
    static int dir1[];
    static int dir2[];
    static boolean valid(int i,int j,int n){
        return (i>=0 && i<n && j>=0 && j<n);
    }
    static void fill(int a,int b,int n,int arr[][]){
        Pair<Integer,Integer>p=new Pair<Integer,Integer>(a,b);
        if(q2.isEmpty()){
           q1.add(p);
           while(!q1.isEmpty()){
               Pair<Integer,Integer> p1=q1.poll();
               int x=p1.getKey();
               int y=p1.getValue();
               q2.add(p1);
               arr[x][y]=-1;
               for(int i=0;i<4;i++){
                   int xp=x+dir1[i];
                   int yp=y+dir2[i];
                   if(valid(xp,yp,n) && arr[xp][yp]==1){
                       q1.add(new Pair<Integer,Integer>(xp,yp));
                   }
               }
               
           }
        }
        else{
           q1.add(p);
           while(!q1.isEmpty()){
               Pair<Integer,Integer> p1=q1.poll();
               int x=p1.getKey();
               int y=p1.getValue();
               arr[x][y]=-1;
               q3.add(p1);
               for(int i=0;i<4;i++){
                   int xp=x+dir1[i];
                   int yp=y+dir2[i];
                   if(valid(xp,yp,n) && arr[xp][yp]==1){
                       q1.add(new Pair<Integer,Integer>(xp,yp));
                   }
               }
               
           }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[][]=new int[n][n];
        dir1=new int[]{1,0,-1,0};
        dir2=new int[]{0,1,0,-1};
        q1=new LinkedList<Pair<Integer,Integer>>();
        q2=new LinkedList<Pair<Integer,Integer>>();
        q3=new LinkedList<Pair<Integer,Integer>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    fill(i,j,n,arr);
                }
            }
        }
        //p
        int min=9999;
        //System.out.println(q2);
        //System.out.println(q3);
        for(Pair<Integer,Integer> p1:q2){
            for(Pair<Integer,Integer> p2:q3){
                int dis=Math.abs(p1.getKey()-p2.getKey())+Math.abs(p1.getValue()-p2.getValue());
                min=Math.min(min,dis);
            }
        }
        System.out.println(min>0?min-1:min);
    }
}
