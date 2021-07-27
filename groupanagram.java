import java.util.*;
import java.lang.*;
class groupanagram{
    static int arr[];
    static long computehash(String s){
        long res=1;
        for(char c:s.toCharArray()){
          if(c>='a'){
            res=res*arr[c-'a'];
            }
        }
        return res;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        long hash;
        Map<Long,ArrayList<String>> mp=new HashMap<Long,ArrayList<String>>();
        arr=new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        for(String s:strs){
            //System.out.println(s);
            hash=computehash(s);
            if(mp.get(hash)==null){
                mp.put(hash,new ArrayList<String>());
            }
            mp.get(hash).add(s);
        }
        List<List<String>> l=new ArrayList<>();
        //System.out.println(mp);
        for(Map.Entry<Long,ArrayList<String>> e:mp.entrySet()){
            l.add(e.getValue());
        }
        return l;
    }
    public static void main(String[] args){
             Scanner in=new Scanner(System.in);
             String arr[]=in.nextLine().replace("[","").replace("]","").split(",");
             //System.out.println(Arrays.toString(arr));
             System.out.println(groupAnagrams(arr));
    }
 }
