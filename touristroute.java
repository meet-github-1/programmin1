/*
Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 1 to N.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.

Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. If you are not able to find such plan, print -1.

Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
 
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.


Sample Input-1:
---------------
4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5

Sample Output-1:
----------------
8

Explanation:
------------
The cheapest route plan is as follows:
1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8


Sample Input-2:
---------------
4 3
1 2 3
1 3 5
2 3 4

Sample Output-2:
----------------
-1
*/
import java.util.*;
import java.lang.*;
class pair{
    int st;
    int ds;
    int pr;
    pair(int p,int x,int y){
        st=p;
        ds=x;
        pr=y;
    }
    public String toString(){
        return pr+" "+st+" "+ds;
    }
}
class touristroute implements Comparator<pair>{
    public int compare(pair p1,pair p2){
        if(p1.pr==p2.pr){
            if(p1.st==p1.st) return p1.ds-p2.ds;
            return p1.st-p2.st;
        }
        return p1.pr-p2.pr;
    }
    static boolean union(int x,int y,int relation[]){
        int rx=find(x,relation);
        int ry=find(y,relation);
        if(rx!=ry){
            relation[ry]=rx;
            return true;
        }
        return false;
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
        List<pair> l=new ArrayList<pair>();
        for(int i=0;i<p;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            int pr=in.nextInt();
            l.add(new pair(x,y,pr));
        }
        l.sort(new touristroute());
        //System.out.println(l);
        int relation[]=new int[n+1];
        for(int i=1;i<=n;i++){
            relation[i]=i;
        }
        int cost=0;
        for(pair ps:l){
            if(union(ps.st,ps.ds,relation)){
                cost+=ps.pr;
            }
        }
        boolean flag=true;
        int k=find(1,relation);
        for(int i=2;i<=n;i++){
            if(find(i,relation)!=k){
                flag=false;
            }
        }
        if(!flag){
            System.out.println(-1);
        }
        else{
            System.out.println(cost);
        }
        
    }
}
