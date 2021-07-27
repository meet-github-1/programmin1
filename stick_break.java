import java.util.*;
import java.lang.*;
class stick_break{
    static boolean satisfy(int md,int arr[],int p){
          int count=0;
          for(int i:arr){
             int div=i/md;
             count=count+div;
          }
          if(count>=p){
             return true;
          }
          return false;
    }
    static int max_piece(int arr[],int n,int p){
        int st=0;
        int sum=0;
        for(int i:arr){
           sum+=i;
        }
        if(sum<p){
        return 0;
        }
        int ed=sum/p;
        int mp=0;
        while(st<ed){
         int mid=(st+ed)/2;
         if(satisfy(mid,arr,p)){
            mp=mid;
            st=mid+1;
         }
         else{
           ed=mid-1;
         }  
        }
        return mp;
    } 
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int p=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(max_piece(arr,n,p));
            }
}
