/*
Venkatadri is a maths teacher.
He is teaching matrices to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the special matrix, 
in the iven matrix A[m][n].
A special matrix has following property:
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, maximum size P of the special matrix.


Sample Input-1:
---------------
5 5
7 8 3 5 6
3 5 1 6 7
3 5 4 3 1
6 2 7 3 2
5 4 7 6 2

Sample Output-1:
----------------
3

Explanation:
------------
The special matrix is:
5 1 6
5 4 3
2 7 3


Sample Input-2:
---------------
4 4
7 8 3 5
3 2 1 6
3 2 3 3
6 2 3 3

Sample Output-2:
----------------
2

Explanation:
------------
The special matrix is:
3 3
3 3
*/
import java.util.*;
import java.lang.*;
class special_matrix{
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
        int rsum[][]=new int[r+2][c+2];
        int csum[][]=new int[r+2][c+2];
        int dsum[][]=new int[r+2][c+2];
        int adsum[][]=new int[r+2][c+2];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                rsum[i][j]=arr[i-1][j-1]+rsum[i][j-1];
                csum[i][j]=arr[i-1][j-1]+csum[i-1][j];
                dsum[i][j]=arr[i-1][j-1]+dsum[i-1][j-1];
                adsum[i][j]=arr[i-1][j-1]+adsum[i-1][j+1];
            }
        }
        int max=0;
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                for(int k=Math.min(r-i,c-j);k>max;k--){
                    int sum=dsum[i+k][j+k]-dsum[i-1][j-1];
                    boolean match=sum==adsum[i+k][j]-adsum[i-1][j+k+1];
                    for(int e=0;e<=k && match;e++){
                        match=match && sum==rsum[i+e][j+k]-rsum[i+e][j-1];
                        match=match && sum==csum[i+k][j+e]-csum[i-1][j+e];
                    }
                  max=match?k:max;   
                }
            }
        }
        System.out.println(max+1);
    }
}
