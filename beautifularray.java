import java.util.*;
import java.lang.*;
class beautifularray{
       static List<Integer> beautifulArray(int n){
              List<Integer> l=new ArrayList<Integer>();
              for(int i=0;i<n;i++){
                l.add(i+1);
              }
              merge(l,n);
              return l;
       }
       static void merge(List<Integer> l,int n){
                 if(n<3) return;
                 List<Integer> p=new ArrayList<Integer>();
                 List<Integer> q=new ArrayList<Integer>();
                 int a=0,b=0;
                 for(int i:l){
                    if(i%2==1){
                     p.add(i/2);
                     a++;
                    }
                    else{
                      q.add(i/2);
                      b++;
                    }
                 }
                 merge(p,a);
                 merge(q,b);
                 for(int i=0;i<n;i++){
                    if(i<a) l.set(i,2*p.get(i)+1);
                    else l.set(i,2*q.get(i-a));
                 }
       }
        public static void main(String[] args){
           Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            System.out.println(beautifulArray(n));
        }
}
