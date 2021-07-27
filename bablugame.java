/*
Bablu is playing a eating challenge game.
The game contains 3 boxes, each box contains P,Q and R number of laddus.

To score in the game the rules are as follows:
	- You can select any two non-empty boxes, 
	and eat one laddu from each box, you will get 1 point.
	- Reepeat the above step, until you can find two non-empty boxes.
	Otherwise game will end.
	
Your task is to help Bablu to score maximum points in the game.

Input Format:
-------------
Three space separated integers, P, Q, R.

Output Format:
--------------
Print an integer, maximum points Bablu can score in the game.


Sample Input-1:
---------------
3 3 4

Sample Output-1:
----------------
5

Explanation:
------------
The game starts with boxes with [3, 3, 4] laddus. 
One optimal solution to score max points is:
- Eat from 1st and 2nd boxes, remaining is [2, 2, 4]
- Eat from 1st and 3rd boxes, remaining is [1, 2, 3]
- Eat from 1st and 3rd boxes, remaining is [0, 2, 2]
- Eat from 2nd and 3rd boxes, remaining is [0, 1, 1]
- Eat from 2nd and 3rd boxes, remaining is [0, 0, 0]
You can't select two non-empty boxes, so the game ends. 
Total: 5 points.


Sample Input-2:
---------------
3 4 5

Sample Output-2:
----------------
6

Explanation:
------------
The game starts with boxes with [3, 4, 5] laddus. 
One optimal solution to score max points is:
- Eat from 1st and 3rd boxes, remaining is [2, 4, 4]
- Eat from 1st and 3rd boxes, remaining is [1, 4, 3]
- Eat from 2nd and 3rd boxes, remaining is [1, 3, 2]
- Eat from 2nd and 3rd boxes, remaining is [1, 2, 1]
- Eat from 2nd and 3rd boxes, remaining is [1, 1, 0]
- Eat from 1st and 2nd boxes, remaining is [0, 0, 0]
You can't select two non-empty boxes, so the game ends. 
Total: 6 points.
*/
import java.util.*;
import java.lang.*;
class bablugame{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arr[]=in.nextLine().split(" ");
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(String s:arr){
            pq.add(Integer.parseInt(s));
        }
        //System.out.println(pq);
        if(pq.size()<=1){
            System.out.println(0);
        }
        else{
            int count=0;
            while(true){
                //System.out.println(pq.peek());
                if(pq.peek()==0) break;
                int a=pq.poll();
                if(pq.peek()==0) break;
                int b=pq.poll();
                pq.add(a-1);
                pq.add(b-1);
                count++;
            }
            System.out.println(count);
        }
    }
}
