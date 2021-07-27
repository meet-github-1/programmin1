/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.

There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.

Your task is to findout the number of regions formed between N cities. 

Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.

Output Format:
--------------
Print an integer, number of regions formed.


Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4

Sample Output-2:
----------------
1

Note: Look HINT for explanation.
*/
import java.util.*;
import java.lang.*;
class regions{
    static void union(int x,int y,int relation[]){
        int rx=find(x,relation);
        int ry=find(y,relation);
        if(rx!=ry){
            relation[ry]=rx;
        }
    }
    static int find(int x,int relation[]){
        if(x!=relation[x]){
            return relation[x]=find(relation[x],relation);
        }
        return x;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int p=in.nextInt();
        int relation[]=new int[n];
        Map<Integer,ArrayList<Integer>> mp=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<p;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            if(mp.get(x)==null){
                mp.put(x,new ArrayList<Integer>());
            }
            mp.get(x).add(y);
        }
        for(int i=0;i<n;i++){
            relation[i]=i;
        }
        for(Map.Entry<Integer,ArrayList<Integer>> e:mp.entrySet()){
            for(int conn:mp.get(e.getKey())){
                union(e.getKey(),conn,relation);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(relation[i]==i){
                count++;
            }
        }
        System.out.println(count);
    }
}
