import java.util.*;
import java.lang.*;
class mango{
    static int n,div;
    static int arr[];
    static boolean countdiv(int mid){
      int count=0;
      for(int i:arr){
         if(mid>i){
           continue;
         }
         else if(i%mid==0){
            count+=(i/mid)-1;
         }
         else{
             count+=(i/mid);
         }

      }
      if(count>div){
        return false;
      }
      return true;
    }
    static int getmax(int low,int high){
       int ans=0; 
       while(low<=high){
           int mid=(low+high)/2;
           if(countdiv(mid)){
               ans=mid;
               high=mid-1;
           }
           else{
             low=mid+1;
             }
       }
       return ans;
    }
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    n=in.nextInt();
	    //div=in.nextInt();
	    arr=new int[n];
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	       arr[i]=in.nextInt();
	       max=Math.max(max,arr[i]);
	    }
	    System.out.println(getmax(1,max));
	}
}
