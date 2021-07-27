/*
There are N celebrities participated in Go-Green Campaign,
All of them joined together and each one planted a tree on a flat land
at different positions.
 
Now, your task is to find the maximum number of trees in single straight line.

Input Format:
-------------
Line-1 -> An integers N, number of trees planted.
Next N lines -> Two space separated integers, position of the tree.

Output Format:
--------------
Print an integer as result.


Sample Input:
-------------
6
1 1
3 2
5 3
4 1
2 3
1 4

Sample Output:
--------------
4

Explanation:
------------

    Y
    |
    |	"
    | 		"			"
    |			"
    |	"			"	
    ------------------------- X
    0   1   2   3   4   5
*/
import java.util.*;
class StLine
{
    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        if(b>a)
            return gcd(b,a);
        return gcd(b,a%b);
    }
    public static String slope(int[]p1,int[]p2)
    {
        int a = Math.abs(p1[0]-p2[0]);
        int b = Math.abs(p1[1]-p2[1]);
        int gcd = gcd(a,b);
        return String.valueOf((int)(a/gcd))+"|"+String.valueOf((int)(b/gcd));
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pts[][] = new int[n][2];
        for(int i=0;i<n;i++)
        {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }
        HashMap<String,HashSet<String>> hs = new HashMap();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                String s = String.valueOf(pts[i][0])+","+String.valueOf(pts[i][1])+","+slope(pts[i],pts[j]);
                HashSet<String> h = hs.getOrDefault(s,new HashSet());
                if(h.size()==0)
                    h.add(String.valueOf(pts[i][0])+","+String.valueOf(pts[i][1]));
                h.add(String.valueOf(pts[j][0])+","+String.valueOf(pts[j][1]));
                hs.put(s,h);
                
            }
        }
        int max = 2;
        for(HashSet<String> val : hs.values())
            max = Math.max(max,val.size());
        System.out.println(max);
    }
}
