/*
The king 'Luther Martin' has a kingdom in the form of square land of size N*N,
So, there are N*N square cells in the land.
You can divide the cell into two halfs either diagonal or anti-diagonal.
	- The diagonal division of the cell indicates by L
	- The anti-diagonal division of the cell indicates by R.
	- '_' indicates no division of the cell.
	
The king is given the following information:
An intgeer N, and N strings, consist of three characters L, R, and '_' ,
where each string length is N. The division may create new zones.

Your task is to divide each cell according to the given information, and
return the number of new zones formed after all the divisions made.

NOTE: Refer hint for pictorial representation of R and L divisions.

Input Format:
-------------
Line-1: An integer N, size of the land.
Line-2: N comma separated strings, each string of length N.
		The string consist only these characers [R,L,_] 

Output Format:
--------------
Print an integers, number of new zones formed.


Sample Input-1:
---------------
4
RLRL,LRLR,RLRL,LRLR

Sample Output-1:
----------------
13

Sample Input-2:
---------------
4
RRLL,R__L,L__R,LLRR

Sample Output-2:
----------------
9


Sample Input-3:
---------------
4
L_RR,_L_R,R_L_,RR_L

Sample Output-3:
----------------
2
*/
import java.util.*;
import java.lang.*;
class diamondregion{
    static int parent[];
    static void union(int x,int y){
        int p1=find(x);
        int p2=find(y);
        if(p1!=p2){
            parent[p1]=p2;
        }
    }
    static int find(int p){
        if(parent[p]!=p){
            return parent[p]=find(parent[p]);
        }
        return p;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String arr[]=in.nextLine().split(",");
        parent=new int[4*n*n];
        for(int i=0;i<n*n*4;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int ind=i*4*n+j*4;
                if(arr[i].charAt(j)=='R'){
                    union(ind,ind+3);
                    union(ind+1,ind+2);
                }
                else if(arr[i].charAt(j)=='L'){
                    union(ind,ind+1);
                    union(ind+2,ind+3);
                }
                else{
                    union(ind,ind+1);
                    union(ind,ind+2);
                    union(ind,ind+3);
                }
                if(i<n-1){
                    union(ind+2,ind+4*n);
                }
                if(j<n-1){
                    union(ind+1,ind+4+3);
                }
            }
        }
        int count=0;
        for(int i=0;i<n*n*4;i++){
            if(parent[i]==i){
                count++;
            }
        }
        System.out.println(count);
    }
}
