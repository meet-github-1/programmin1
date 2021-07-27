import  java.util.*;
import java.lang.*;
class lds{
   public static void main(String[] args){
     Scanner in=new Scanner(System.in);
     int n=in.nextInt();
     int arr[]=new int[n];
     for(int i=0;i<n;i++){
       arr[i]=in.nextInt();
     }
     int dp[]=new int[n];
     Arrays.fill(dp,1);
     int max=1;
     for(int i=0;i<n;i++){
     int mx=dp[i];
      for(int j=i-1;j>=0;j--){
         if(arr[i]<arr[j]){
            mx=Math.max(mx,dp[j]+1);
         }
      }
      dp[i]=mx;
      max=Math.max(max,dp[i]);
     }
     System.out.println(max);
   }
}
