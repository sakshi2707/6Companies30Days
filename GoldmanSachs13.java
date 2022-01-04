//Q13. Decode the string
//Solution by Sakshi Gupta
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
static String decodedString(String s){
        String result = "";
        String res = "";
        int n = 0;
        Stack<Character> stk = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            if(!stk.isEmpty() && s.charAt(i) == ']') {
                res = "";
                String cnt = "";
                while(!stk.isEmpty() && stk.peek() != '[') {
                    res = stk.pop()+res;
                }
                if(!stk.isEmpty() && stk.peek() == '[') stk.pop();
                if (!stk.isEmpty() && Character.isDigit(stk.peek())) {
                    while (!stk.isEmpty() && Character.isDigit(stk.peek())) {
                        cnt = stk.pop()+cnt;
                    }
                    n = Integer.parseInt(cnt);
                }
                for(int j = 0;j < n;j++) result = result + res;
                if(!stk.isEmpty()) {
                    for (int j = 0; j < result.length(); j++)
                        stk.push(result.charAt(j));
                    result = "";
                }
            }
            else stk.push(s.charAt(i));
        }
        return result;
}}
