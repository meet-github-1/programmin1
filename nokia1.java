import java.util.*;
import java.lang.*;
class nokia1{
    static int MOD=1000000007;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        if(n==1){
            System.out.println(10);
        }
        else{
            long arr1[]=new long[10];
            long arr2[]=new long[10];
            for(int i=0;i<=9;i++){
                arr1[i]++;
            }
            n--;
            while(n>0){
                arr2[0]=(arr1[4]+arr1[6])%MOD;
                arr2[1]=(arr1[6]+arr1[8])%MOD;
                arr2[2]=(arr1[7]+arr1[9])%MOD;
                arr2[3]=(arr1[4]+arr1[8])%MOD;
                arr2[4]=(arr1[0]+arr1[3]+arr1[9])%MOD;
                arr2[5]=0;
                arr2[6]=(arr1[0]+arr1[1]+arr1[7])%MOD;
                arr2[7]=(arr1[2]+arr1[6])%MOD;
                arr2[8]=(arr1[1]+arr1[3])%MOD;
                arr2[9]=(arr1[2]+arr1[4])%MOD;
                for(int i=0;i<=9;i++){
                    arr1[i]=arr2[i];
                }
                n--;
            }
            long count=0;
            for(int i=0;i<=9;i++){
                count=(count+arr1[i])%MOD;
            }
            System.out.println(count%MOD);
        }
    }
}
