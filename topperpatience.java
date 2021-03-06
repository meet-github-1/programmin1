/*
In a class of N students, each student has different levels of IQ and 
different levels of patience. Each student is numbered from 0 to N-1.

To identify a student with number A, call him "Student A".

The teacher has created 'N-1' IQ pairs based on his observation of the students.
Each IQ pair (a,b), indicates Student 'a' is more  intelligent than Student 'b'.

The teacher also has a measure of  the patience of the students in the form of 
a list of  'N' integers. Where patience[i]=p, indicates Student 'i' has patience 'p'.

Now your task is to find the Result[i]= r, r is least patience student, 
among all the students who has more or equal IQ than Student[i], 
where 'i' is in range of [0..N-1].

Input Format:
-------------
Line-1 -> an integers N, number of students
Next 'N-1' lines -> two space seperated integers, indicates a pair (a, b).
Last Line -> N space seperated integers, patience levels of students

Output Format:
------------------
Print space seperated Result[i], where 'i' is in [0 .. N-1].


Sample Input-1:
-------------------
6
1 3
2 4
3 5
0 3
3 4
4 2 6 8 3 1

Sample Output-1:
---------------------
0 1 2 1 1 5

Explanation:
---------------
For Result[4]:
	Student 0, 1 has more IQ than Student 3, which has more IQ than Student 4.
	Among students 0,1,3,4,  'student 1' has less patience.
For Result[5]:
	Student 0, 1 has more IQ than Student 3, which has more IQ than Student 5.
	Among students 0,1,3,5,  'student 5' has less patience.


Sample Input-2:
-------------------
8
1 0
2 1
3 1
3 7
4 3
5 3
6 3
3 2 5 4 6 1 7 0

Sample Output-2:
---------------------
5 5 2 5 4 5 6 7
*/
import java.util.*;
import java.lang.*;
class topperpatience{
    static int MAX=99999;
    static int dp[];
    static int pat[];
    static boolean vis[];
    static int getminpattopper(Map<Integer,ArrayList<Integer>> mp,int root){
        if(dp[root]!=-1){
            return dp[root];
        }
        else if(vis[root]){
            return 0;
        }
        else{
            vis[root]=true;
            int min=pat[root];
            int pind=root;
            for(int i:mp.get(root)){
                int ind=getminpattopper(mp,i);
                if(pat[ind]<min){
                    pind=ind;
                    min=pat[ind];
                }
            }
            dp[root]=pind;
            return dp[root];
        }
        
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Map<Integer,ArrayList<Integer>> mp=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            mp.get(b).add(a);
        }
        pat=new int[n];
        dp=new int[n];
        vis=new boolean[n];
        for(int i=0;i<n;i++){
            pat[i]=in.nextInt();
            dp[i]=-1;
        }
        int out[]=new int[n];
        for(int i=0;i<n;i++){
            int ans=getminpattopper(mp,i);
            out[i]=ans;
        }
        for(int i:out){
            System.out.print(i+" ");
        }
    }
}
