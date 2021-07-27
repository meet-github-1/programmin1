import java.util.*;
import java.lang.*;
class merge{
     static void mergehelper(int arr[],int low,int mid,int high){
           int ind1=mid-low+1;
           int ind2=high-mid;
           int ar1[]=new int[ind1];
           int ar2[]=new int[ind2];
           for(int i=0;i<ind1;i++){
               ar1[i]=arr[low+i];
           }
           for(int i=0;i<ind2;i++){
               ar2[i]=arr[mid+1+i];
           }
           int i=0;
           int j=0;
           int st=low;
           while(i<ind1 && j<ind2){
                if(ar1[i]<=ar2[j]){
                   arr[st]=ar1[i];
                   i++;
                }
                else{
                   arr[st]=ar2[j];
                   j++;
                }
                st++;
           }
           while(i<ind1){
               arr[st]=ar1[i];
               st++;
               i++;
           }
           while(j<ind2){
               arr[st]=ar2[j];
               st++;
               j++;
           }
           
     }
     static void mergesort(int arr[],int low,int high){
           if(low>=high){
             return;
            }
            int mid=(low+high)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            mergehelper(arr,low,mid,high);
     }
     public static void main(String[] args){
            Scanner in=new Scanner(System.in);
             int n=in.nextInt();
             int arr[]=new int[n*2];
             int count=0;
             for(int i=0;i<2;i++){
                for(int j=0;j<n;j++){
                   arr[count]=in.nextInt();
                   count++;
                }
                }
                mergesort(arr,0,n*2-1);
                System.out.println(Arrays.toString(arr));
                if(n*2%2==0){
                System.out.println(arr[n*2/2-1]+" "+arr[n*2/2]);
                   System.out.println((arr[n*2/2-1]+arr[n*2/2])/2);
                }
                else{
                  System.out.println(arr[n*2/2]);
                 }
     }
}
