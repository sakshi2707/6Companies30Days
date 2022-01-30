//Q8.Maximum Height Tree
//Solution by Sakshi Gupta
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.height(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int height(int N){
        return (int)(-1+Math.sqrt(1+8*N))/2;
    }
}
