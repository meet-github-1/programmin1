import java.util.*;
import java.lang.*;
class frogjump{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
           nums[i]=in.nextInt();
        }
        int len=nums.length;
        int min[]=new int[len];
        Arrays.fill(min,Integer.MAX_VALUE);
        min[0]=0;
        for(int i=0;i<len;i++){
            int dis=nums[i];
            for(int j=i+1;j<=i+dis;j++){
                if(j<len){
                min[j]=Math.min(min[j],min[i]+1);
                }
            }
        }
        //System.out.println(Arrays.toString(min));
        System.out.println(min[len-1]);
         }
 }
