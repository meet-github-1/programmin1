import java.util.*;
import java.lang.*;
class pair{
    static int dp[][];
    static boolean ispossible(int x,int y,int a,int b){
        if(x>a || y>b) return false;
        else if(x==a && y==b) return true;
        else if(dp[x][y]!=0) return dp[x][y]==1?true:false;
        else{
            dp[x][y]=(ispossible(x+y,y,a,b) || ispossible(x,y+x,a,b))?1:-1;
            return dp[x][y]==1?true:false;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        int d=in.nextInt();
        dp=new int[c+1][d+1];
        if(ispossible(a,b,c,d)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
