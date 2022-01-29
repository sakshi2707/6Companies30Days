//Q5.Total number of ways n can be expressed as sum of xth power of unique natural numbers
//Solution by Sakshi Gupta
// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends



class Solution
{
     static int power(int num, int n)
    {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return power(num, n / 2) * power(num, n / 2);
        else
            return num * power(num, n / 2)
                * power(num, n / 2);
    }
 
    
    static int checkRecursive(int x, int n, int curr_num,
                              int curr_sum)
    {
    
    
        int results = 0;
 
       
        int p = power(curr_num, n);
        while (p + curr_sum < x) {
         
            results += checkRecursive(x, n, curr_num + 1,
                                      p + curr_sum);
            curr_num++;
            p = power(curr_num, n);
        }
 
        
        if (p + curr_sum == x)
            results++;
 
     
        return results;
    }
    static int numOfWays(int n, int x)
    {return checkRecursive(x, n, 1, 0);
 
        
    }
}
