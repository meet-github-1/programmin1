/*
In an exhibition, A shopkeeper organizing a game stall,
'N' peolple can participate in the game, each person will get a token 
with a positive number printed on both sides(possibly different).

After that, all of them place the 'N' tokens on a table in a row, 

Now, the shopkeeper will turn all the tokens upside down.
For example, if a token placed on a table shows 5 upside 2 downside
after turn it will show 2 upside and 5 downside.

After turning all the tokens, if the number X on the downside of the token, 
is not on the upside of any other token, then the person who owns that token 
will be the winner. If no such number found, NO winner.

Based on following information and you need to find X.
You will be given 'N' upside numbers and 'N' down side numbers on tokens 
when placed on table.

Note: You need to print the number X, and X to be smallest of all such tokens.
if no such number X present, print 0.

Input Format:
----------------
Line-1 -> an integers N, number of tokens
Line-2 -> N space seperated integers, upside numbers
Line-3 -> N space seperated integers, downside numbers

Output Format:
------------------
Print the integer X if found.
Otherwise print '0'.


Sample Input-1:
-------------------
5
1 2 4 4 7
1 3 4 1 3

Sample Output-1:
---------------------
2

Explanation: 
------------
If you turn the second token, the upside numbers are [1,3,4,4,7]
and the downside numbers are [1,2,4,1,3].
You choose the second token, which has number 2 on the downside, 
and it is not on the upside numbers of any token, so 2 is thw winner number.


Sample Input-2:
-------------------
5
1 3 4 4 1
1 4 3 1 3

Sample Output-2:
---------------------
0
*/
import java.util.*;
import java.lang.*;
class updowntoken{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Map<Integer,Boolean> mp=new HashMap<Integer,Boolean>();
        for(int i=0;i<n;i++){
            mp.put(in.nextInt(),true);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i:arr){
            if(!mp.getOrDefault(i,false)){
                pq.add(i);
            }
        }
        System.out.println(pq.size()==0?0:pq.poll());
    }
}
