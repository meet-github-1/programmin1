/*
A Frog is on Land at position-0 and trying to reach the lake at position-P.
There are N traps on the land given as Traps[], where Traps[i] is the position
of a trap.

The frog can jump from it's current position to F steps forward (to right) or 
B steps backward (to left). Te frog cannot to consecutive backward jumps.
The frog should avoid to jump on the position trap[i], where trap[i] is +ve integer.
The frog cannot jump if the position value < 0, but can jump beyond the Lake position.


Your task is to find the minimum number of jumps needed by the frog to reach 
the lake. If it is possible to reach the lake return no.of jumps, 
Otherwise return -1.

Input Format:
-------------
Line-1: Four space separated integers, N, F, B, P.
Line-2: N space separated integers, Traps[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5 4 9 7
11 5 14 16 6

Sample Output-1:
----------------
5

Explanation:
------------
3 forward jumps starts from, 0 to 4, 4 to 8, 8 to 12
1 backward jump from,12 to 3.
1 forward jump from, 3 to 7.


Sample Input-2:
---------------
6 3 5 13
2 5 16 11 19 23

Sample Output-2:
----------------
7


Sample Input-3:
---------------
6 3 5 13
2 7 15 18 17 23

Sample Output-3:
----------------
-1
*/
import java.util.*;
import java.lang.*;
import javafx.util.Pair;
class frog_jump{
    static int min_steps(Set<Pair<Integer,Integer>> st,int f,int b,int p){
       Queue<Pair<Integer,Integer>> q=new LinkedList<Pair<Integer,Integer>>();
       q.add(new Pair(0,0));
       int mx=2*p;
       int stp=0;
       while(!q.isEmpty()){
           int sz=q.size();
           for(int i=0;i<sz;i++){
               Pair<Integer,Integer> pr=q.poll();
               int dir=pr.getKey();
               int pos=pr.getValue();
               if(pos==p){
                   return stp;
               }
               Pair <Integer,Integer>p1=new Pair<Integer,Integer>(0,pos+f);
               Pair <Integer,Integer>p2=new Pair<>(1,pos-b);
               if(pos+f<=mx && st.add(p1)){
                   q.add(p1);
               }
               if(dir==0 && pos-b>=0 && st.add(p2)){
                   q.add(p2);
               }
           }
           stp++;
       }
       return -1;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int f=in.nextInt();
        int b=in.nextInt();
        int p=in.nextInt();
        Set<Pair<Integer,Integer>> st=new HashSet<Pair<Integer,Integer>>();
        for(int i=0;i<n;i++){
            int tr=in.nextInt();
            st.add(new Pair(0,tr));
            st.add(new Pair(1,tr));
        }
        System.out.println(min_steps(st,f,b,p));
    }
}
