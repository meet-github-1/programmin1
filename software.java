/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/
import java.util.*;
import java.lang.*;
class software implements Comparator<String>{
    public int compare(String s1,String s2){
        return s2.compareTo(s1);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String arr[]=in.nextLine().split(" ");
        List<String> l=Arrays.asList(arr);
        PriorityQueue<String> pq=new PriorityQueue<String>(new software());
        Map<String,String> mp=new HashMap<String,String>();
        for(String s:arr){
            if(s.charAt(s.length()-1)=='0'){
                String sub=s.substring(0,s.indexOf('0')-1);
                if(l.indexOf(sub)==-1){
                    mp.put(sub,s);
                    pq.add(sub);
                }
            }
            else{
                pq.add(s);
            }
        }
        String sb=pq.poll();
        if(mp.get(sb)!=null){
            System.out.println(mp.get(sb));
        }
        else{
            System.out.println(sb);
        }
    }
}
