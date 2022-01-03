//Q9.Given a pattern containing only I's and D's. I for increasing and D

         //for decreasing.Devise an algorithm to print the minimum number following

        //that pattern.
//Solution by Sakshi Gupta
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
            // code here
        Stack<Integer> st=new Stack<>();
       String ss="";
       for(int i=0;i<=S.length();i++)
       {
           st.push(i+1);
           if(i==S.length() || S.charAt(i)=='I')
           {
             while(st.size()>0)
             {
                 ss+=String.valueOf(st.pop());
             }
           }
       }
       return ss;
    }
}
