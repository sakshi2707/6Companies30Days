//Q4.Partition Equal Subset Sum
//Solution by Sakshi Gupta
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
        int sum = 0;
        for (int i=0; i<N; i++) {
            sum = sum + nums[i];
        }
        
        if (sum%2 != 0)
            return 0;
        
        int targetsum = sum / 2;
        return subsetsum (nums, N, targetsum);
    }
    
    static int subsetsum (int[]nums, int n, int targetsum)
    {
        int [][] matrix = new int[n+1][targetsum+1];
        
        for (int j=0; j<=targetsum; j++) {
            matrix[0][j] = 0;
        }
        
        for (int i=0; i<n+1; i++) {
            matrix[i][0] = 1;
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=targetsum; j++) {
                if (nums[i-1] <= j){
                    matrix[i][j] = (matrix[i-1][j - nums[i-1]] == 1 || matrix[i-1][j] == 1)?1:0;
                }
                else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        
        return matrix[n][targetsum];
    }
}
