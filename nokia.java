import java.util.*;
import java.lang.*;
class nokia{
    static Map<Integer,int[]> mp;
    static List<String> l;
    static void getnumbers(int st,int num,String s){
        if(num==0){
            l.add(s);
        }
        else{
            for(int i:mp.get(st)){
                getnumbers(i,num-1,s+i);
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        mp=new HashMap<Integer,int[]>();
        mp.put(0,new int[]{4,6});
        mp.put(1,new int[]{6,8});
        mp.put(2,new int[]{7,9});
        mp.put(3,new int[]{4,8});
        mp.put(4,new int[]{0,3,9});
        mp.put(5,new int[]{});
        mp.put(6,new int[]{0,1,7});
        mp.put(7,new int[]{2,6});
        mp.put(8,new int[]{1,3});
        mp.put(9,new int[]{2,4});
        l=new ArrayList<String>();
        if(n==1){
            System.out.println(10);
        }
        else{
            for(int i=0;i<=9;i++){
                getnumbers(i,n-1,""+i);
            }
            System.out.println(l.size());
        }
    }
}
