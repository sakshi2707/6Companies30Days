//Q8.Count ways to N'th Stair(Order does not matter)
//Solution by Sakshi Gupta
// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking total number of stairs
		    int m = sc.nextInt();
		    
		    
		    Solution obj = new Solution();
		    
		    		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
  
    Long countWays(int m)
    {
        Long res[] = new Long[m+1];
        
        //base cases
        res[0] = 1L; 
        res[1] = 1L;
        
       
        for (int i = 2; i <= m; i++)  
            res[i] = (res[i-2] + 1);
      
        //returning the result.
        return res[m];
        
    }
    
}
