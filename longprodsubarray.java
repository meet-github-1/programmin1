import java.util.*;
import java.lang.*;
class longprodsubarray{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String arr[]=s.split(" ");
        int len=arr.length;
        int ar[]=new int[len];
        int j=0;
        for(String s1:arr){
            ar[j]=Integer.parseInt(s1);
            j++;
        }
        int fn=-1,ip=-1,max=0,sum=0;
        for(int i=0;i<len;i++){
            //System.out.println(ar[i]);
            if(fn==-1 && ar[i]<0) fn=i;
            if(ar[i]<0) sum++;
            if(ar[i]==0){
                sum=0;
                fn=-1;
                ip=i;
            }
            if(sum%2==0){
                max=Math.max(i-ip,max);
            }
            else{
                max=Math.max(i-fn,max);
            }
        }
        System.out.println(max);
    }
}
