/*
Jason Statham is a well known transporter.
He transports goods from one place to other place using his container.
The container is divided into M*N slots, you can place M*N items in it.
In the container few slots are closed, you can't use them.
No other item can move from it.

When the items are loaded the container looks like an M*N grid, 
but to unload the items from the container it is turned 90-derees clockwise.
So, the Items in the container moves through the empty slots and set one on one.
If there is an closed slot, the items will be fall on the closed slot.

You will be given a matrix of size M*N, consists of 3 letters [I,O,S]
Where I indicates item, O indicates closed slot, S indicates empty slot.

Your task is to help Jason Stathamto know the positions of items, empty slots and 
closed slots after turning the container 90-degree clockwise.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the container
Next M lines: A string of length N, consists only 3 characters [I, O, S]

Output Format:
--------------
Print a charcter matrix of size N*M as described in sample.


Sample Input-1:
---------------
2 3
ISI
ISO

Sample Output-1:
----------------
SS
II
OI

Explanation:
------------
Look at hint for explanation.


Sample Input-2:
---------------
3 6
IIOSOS
IIIOSS
IIISIS

Sample Output-2:
----------------
SII
SII
IIO
IOS
ISO
ISS

Explanation:
------------
Look at hint for explanation.
*/
import java.util.*;
import java.lang.*;
class itemslots{
    static char[][] move90(char arr[][],int r,int c){
        char tr[][]=new char[c][r];
        int c1=0;
        for(int i=0;i<c;i++){
            c1=0;
            for(int j=r-1;j>=0;j--){
                tr[i][c1]=arr[j][i];
                c1++;
            }
        }
        for(int j=0;j<r;j++){
            for(int i=0;i<c;i++){
                //System.out.println(i+" "+j);
                //p
                int prev=i;
                if(tr[i][j]=='S'){
                    while(prev>0 && tr[prev-1][j]=='I'){
                        tr[prev][j]=tr[prev-1][j];
                        prev--;
                    }
                    tr[prev][j]='S';
                }
            }
        }
        return tr;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int r=in.nextInt();
        int c=in.nextInt();
        char arr[][]=new char[r][c];
        for(int i=0;i<r;i++){
            String s=in.next();
            for(int j=0;j<c;j++){
                arr[i][j]=s.charAt(j);
            }
        }
        char trans[][]=move90(arr,r,c);
        for(char ar[]:trans){
            for(char c1:ar){
                System.out.print(c1);
            }
            System.out.println();
        }
    }
}
