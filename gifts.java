import java.util.*;
import java.lang.*;
class gifts{
  public static void main(String[] args){
      Scanner in=new Scanner(System.in);
      int n=in.nextInt();
      int k=in.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=in.nextInt();
      }
      int count=0;
      boolean vis[]=new boolean[n];
      for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
           if((arr[i]+arr[j])%k==0 && !vis[i] && !vis[j]){
               count++;
               vis[i]=true;
               vis[j]=true;
           }
        }
      }
      System.out.println(count*2);
  }
}
