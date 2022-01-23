//Q14.Given a destination D , find the minimum number of steps required to reach that destination.
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
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int D){
        // code here
        int target = Math.abs(D), sum = 0, step = 0;
        
        while(sum < target || (sum-target)%2 != 0)
        {
            step++;
            sum += step;
        }
        return step;
    }
}
