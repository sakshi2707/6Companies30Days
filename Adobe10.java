//Q10.Elections
//Solution by Sakshi Gupta
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
                TreeMap<String, Integer> tm = new TreeMap<>();
        
        for(int i=0;i<n;i++)
        {
            if(!tm.containsKey(arr[i]))
            {
                tm.put(arr[i],1);
            }
            else
            {
                tm.put(arr[i], tm.get(arr[i])+1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        String temp = "";
        for(Map.Entry<String, Integer> e : tm.entrySet())
        {
            if(e.getValue() > max)
            {
                temp = e.getKey();
                max = e.getValue();
            }
        }
        String res[] = new String[2];
        res[0] = temp;
        res[1] = String.valueOf(max);
        return res;
    }
}


