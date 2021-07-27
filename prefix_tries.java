/*
In an english training institute, the trainer Reeta given a task to the trainees.
We know that, in english we have prefixes and suffixes for the words.
You can divide a word as concatenation of prefix and suffix.
i.e., word = prefix + suffix, another = an + other

You will be given a list of prefixes and a statement consisting of words.
Now, the task given to the trainees is as follows:
	- Replace all the words in the statement with the prefix, 
	  if you found prefix of that word in the list.
	- If you found more than one prefix in the list for a word in the statement,
	  replace the word with the prefix that has the shortest length.

Your task is to help the trainees to prepare and print the final statement
after all the replacements done.


Input Format:
-------------
Line-1: Space separated strings, prefixes.
Line-2: A single line of words, statement.

Output Format:
--------------
Print the String, the final statement.


Sample Input-1:
---------------
am add mean ref 
amigos used to address or refer to a friend

Sample Output-1:
----------------
am used to add or ref to a friend


Sample Input-2:
---------------
th the pa tho
thomas the trainer teaches theroy part of thermodynamics

Sample Output-2:
----------------
th th trainer teaches th pa of th
*/
import java.util.*;
import java.lang.*;
class TrieNode{
    char ltr;
    TrieNode child[];
    boolean isword;
    String word;
    TrieNode(char l){
        ltr=l;
        child=new TrieNode[26];
        isword=false;
        word=null;
    }
    public String toString(){
        return ltr+" ";
    }
}
class prefix_tries{
    static TrieNode root;
    static void formtrie(String prf[]){
        TrieNode temp;
        for(String s:prf){
            temp=root;
            for(char c:s.toCharArray()){
                if(temp.child[c-'a']==null){
                    temp.child[c-'a']=new TrieNode(c);
                }
                temp=temp.child[c-'a'];
            }
            temp.isword=true;
            temp.word=s;
        }
    }
    static String findprefix(String s){
        TrieNode temp=root;
        //System.out.println(Arrays.toString(temp.child));
        for(char c:s.toCharArray()){
            if(temp.child[c-'a']!=null){
                if(temp.child[c-'a'].isword){
                    return temp.child[c-'a'].word;
                }
                temp=temp.child[c-'a'];
            }
            else{
                break;
            }
        }
        return s;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        root=new TrieNode(' ');
        String prf[]=in.nextLine().split(" ");
        formtrie(prf);
        String sent[]=in.nextLine().split(" ");
        String out="";
        for(String s:sent){
            String pr=findprefix(s);
            //System.out.println(pr);
            out=out+pr;
            out=out+" ";
        }
        System.out.println(out);
    }
}
