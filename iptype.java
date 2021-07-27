/*
Bob Kahn is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.

Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid
*/
import java.util.*;
import java.lang.*;
class iptype{
    static boolean valid(String s,String type){
        if(type.equals("Type-I")){
            int len=s.length();
            if(len>3 || len<=0){
                return false;
            }
            else{
                boolean st=true;
                int num=0;
                for(int i=0;i<len;i++){
                    if(s.charAt(i)>'0' && s.charAt(i)<='9'){
                        num=num*10+s.charAt(i)-'0';
                        st=false;
                    }
                    else{
                        if(s.charAt(i)=='0'){
                            if(st && len>1){
                                return false;
                            }
                            else{
                                num=num*10;
                                continue;
                            }
                        }
                        else{
                            return false;
                        }
                    }
                }
                if(num>=0 && num<=255){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            int nm=0;
            for(int i=0;i<4;i++){
                nm=nm+('f'-'a')+10;
            }
            int len=s.length();
            if(len>4 || len<=0){
                return false;
            }
            else{
                int num=0;
                for(int i=0;i<len;i++){
                    if((s.charAt(i)>='0' && s.charAt(i)<='9') || (s.charAt(i)>='a' && s.charAt(i)<='f')){
                        num=num+((s.charAt(i)>='0' && s.charAt(i)<='9')?s.charAt(i)-'0':s.charAt(i)-'a'+10);
                    }
                    else{
                       return false;
                    }
                }
                if(num>=0 && num<=nm){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
    public static void main(String[] args){
          Scanner in=new Scanner(System.in);
           String st=in.next();
           if(st.contains(".")){
               String arr[]=st.split("\\.");
               String type="Type-I";
               boolean flag=true;
                if(arr.length!=4){
                   flag=false;
               }
               for(String s:arr){
                  if(!valid(s,type)){
                     flag=false;
                     break;
                  }
               }
               if(!flag){
                   System.out.println("Invalid");
               }
               else{
                   System.out.println(type);
               }
           }
           else if(st.contains(":")){
               String arr[]=st.split("\\:");
               String type="Type-II";
               boolean flag=true;
                if(arr.length!=8){
                   flag=false;
               }
               for(String s:arr){
                  if(!valid(s,type)){
                     flag=false;
                     break;
                  }
               }
               if(!flag){
                   System.out.println("Invalid");
               }
               else{
                   System.out.println(type);
               }
           }
           else{
               System.out.println("Invalid");
           }
    }
}
