/*
Reena has to sent the mails regularly.
She used emphasize any word W based on a given set of words[].
Two emphasize the words she used enclose them with <i> and </i> tag.
The emphasize procedure of the sub-words of W is as follows:
	
	- If two sub-words are intersected with each other, 
	  enclose them with one <i></i> tag.
	
	- If two sub-words are enclosed with <i></i> tag and neighbours also,
	  then merge the sub-words as one and enclose with one <i> </i> tag.

You will be given the word W, and set of words[] to emphasize.
Your task is to help Reena to emphasize the word W.
and print it.

Input Format:
-------------
Line-1: A string W, the word.
Line-2: space separated strings, set of words[].

Output Format:
--------------
Print the string, the emphasized string.

Sample Input-1:
---------------
kmitngit123
it 123

Sample Output-1:
----------------
km<i>it</i>ng<i>it123</i>


Sample Input-2:
---------------
qwertykeypad
qwerty key pad

Sample Output-2:
----------------
<i>qwertykeypad</i>
*/
import java.util.*;
import java.lang.*;
class emphasize{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        in.nextLine();
        String arr[]=in.nextLine().split(" ");
        int len=s.length();
        boolean str[]=new boolean[len];
        int start=0;
        for(String sr:arr){
            int ln=sr.length();
            for(int i=0;i<len;i=start+1){
                start=s.indexOf(sr,i);
                //System.out.println(start);
                if(start!=-1){
                    Arrays.fill(str,0+start,0+start+ln,true);
                }
                else{
                    break;
                }
            }
        }
        String out="";
        for(int i=0;i<len;i++){
            if(str[i] && (i==0 || !str[i-1])){
                out=out+"<i>";
            }
            else if(i>0 && (!str[i] && str[i-1])){
                out=out+"</i>";
            }
            out=out+s.charAt(i);
        }
        if(str[len-1]){
            out=out+"</i>";
        }
        System.out.println(out);
    }
}
