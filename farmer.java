import java.util.*;
import java.lang.*;
class farmer{
    static int dis(int a,int b,int x,int y){
        return Math.abs(a-x)+Math.abs(b-y);
    }
    static int mindistance(int arr[][],int r,int c,int tr,int tc,int fr,int fc){
        int min=Integer.MAX_VALUE;
       for(int ar[]:arr){
           min=Math.min(min,dis(fr,fc,ar[0],ar[1])-dis(tr,tc,ar[0],ar[1]));
       } 
       int sum=0;
       for(int ar[]:arr){
           sum=sum+dis(ar[0],ar[1],tr,tc);
       }
       return 2*sum+min;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int r=in.nextInt();
        int c=in.nextInt();
        int tr=in.nextInt();
        int tc=in.nextInt();
        int fr=in.nextInt();
        int fc=in.nextInt();
        int nw=in.nextInt();
        int arr[][]=new int[nw][2];
        for(int i=0;i<nw;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        System.out.println(mindistance(arr,r,c,tr,tc,fr,fc));
    }
}
