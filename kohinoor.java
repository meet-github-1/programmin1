/*
Kohinoor diamond is robbed by Hrithik,
He kept the diamond in a suitcase, the suitcase has a lock with 4 circular wheels, 
and each wheel consist of 0-9 digits in the order 0,1,2,3,4,5,6,7,8,9 only.
You can rotate a wheel from 0 to 9 or 9 to 0.

As the diamond is most valuable, the lock has some traps,
if anybody try to unlock the suitcase and reached any one of the traps,
the suitcase will be blasted. And you will be dead.

Initially, the suitcase lock is set to 0000.
and you will be given the unlock key, your task to find and print
the minimum number of rotations required to unlock the suitcase.
If it is not possible to unlock the suitcase without blasting, print -1.

NOTE:
In one rotation you can choose any one wheel and 
rotate to its next or previous digit.


Input Format:
-------------
Line-1: space separated strings, each string of length 4 and contains only digits [0-9]
Line-2: A string, key to unlock.

Output Format:
--------------
Print an integer, the minimum number of rotations required to unlock.


Sample Input-1:
---------------
0302 0202 0203 2323 3003
0303 

Sample Output-1:
----------------
8

Explanation:
------------
To unlock the suitcase the valid rotations are as follows:
0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 0202 > 0302 > 0303.


Sample Input-2:
---------------
6656 6676 6766 6566 5666 7666 6665 6667
6666 

Sample Output-2:
----------------
-1

Explanation:
------------
You can't unlock the suitcase.
*/
import java.util.*;
import java.lang.*;
class kohinoor{
    static int get_min(String arr[],String f){
        Map<String,Boolean> mp=new HashMap<String,Boolean>();
        for(String s:arr){
            mp.put(s,true);
        }
        if(mp.getOrDefault("0000",false) || mp.getOrDefault(f,false)){
            return -1;
        }
        Map<String,Boolean> vis=new HashMap<String,Boolean>();
        Queue<String> q=new LinkedList<String>();
        int count=0;
        q.add("0000");
        vis.put("0000",true);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                if(q.peek().equals(f)){
                    return count;
                }
                else{
                    String s=q.poll();
                    for(int j=0;j<4;j++){
                        char c=s.charAt(j);
                        String s1=s.substring(0,j)+(c!='9'?(char)(c+1):'0')+s.substring(j+1);
                        String s2=s.substring(0,j)+(c!='0'?(char)(c-1):'9')+s.substring(j+1);
                        if(!mp.getOrDefault(s1,false) && !vis.getOrDefault(s1,false)){
                            vis.put(s1,true);
                            q.add(s1);
                        }
                        if(!mp.getOrDefault(s2,false) && !vis.getOrDefault(s2,false)){
                            vis.put(s2,true);
                            q.add(s2);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
        
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arr[]=in.nextLine().split(" ");
        String s1=in.next();
        System.out.println(get_min(arr,s1));
    }
}
