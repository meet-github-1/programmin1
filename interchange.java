import java.util.*;
import java.lang.*;
class interchange{
    static Map<Integer,List<Integer>> mp;
    static boolean vis[];
    static ArrayList<Integer> l;
    static void dfs(int st){
        if(vis[st]){
            return;
        }
        else{
            vis[st]=true;
            l.add(st);
            //System.out.println(st);
            for(int i:mp.get(st)){
                dfs(i);
            }
        }
    }
    static void sort(ArrayList<Integer> al,StringBuilder sb,int ln){
        int sz=al.size();
        char arr[]=new char[sz];
        int ind=0;
        for(int i:al){
            arr[ind++]=sb.charAt(i);
        }
        Arrays.sort(arr);
        Collections.sort(al);
        ind=0;
        for(int i:al){
            sb.setCharAt(i,arr[ind++]);
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        StringBuilder sb=new StringBuilder(s);
        int ln=s.length();
        int n=in.nextInt();
        int arr[][]=new int[n][2];
        mp=new HashMap();
        List<ArrayList<Integer>> l1=new ArrayList<ArrayList<Integer>>();
        vis=new boolean[ln];
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
            if(mp.get(arr[i][0])==null){
                mp.put(arr[i][0],new ArrayList<Integer>());
            }
            if(mp.get(arr[i][1])==null){
                mp.put(arr[i][1],new ArrayList<Integer>());
            }
            mp.get(arr[i][0]).add(arr[i][1]);
            mp.get(arr[i][1]).add(arr[i][0]);
        }
        //System.out.println(mp);
        for(int i=0;i<ln;i++){
            if(mp.get(i)==null){
                mp.put(i,new ArrayList<Integer>());
            }
            l=new ArrayList<Integer>();
            dfs(i);
            if(l.size()>1){
                l1.add(l);
            }
        }
        for(ArrayList<Integer> al:l1){
            sort(al,sb,ln);
        }
        //System.out.println(l1);
        System.out.println(sb.toString());
    }
}
