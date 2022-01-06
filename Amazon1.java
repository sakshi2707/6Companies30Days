//Q1.Calculating Maximum Profit
//Solution by Sakshi Gupta
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int price[]) {
        // code here
        int profit[][] = new int[k + 1][ n + 1];


for (int i = 0; i <= k; i++)
profit[i][0] = 0;



for (int j = 0; j <= n; j++)
profit[0][j] = 0;

for (int i = 1; i <= k; i++)
{
int prevDiff = Integer.MIN_VALUE;
for (int j = 1; j < n; j++)
{
prevDiff = Math.max(prevDiff,
profit[i - 1][j - 1] -
price[j - 1]);
profit[i][j] = Math.max(profit[i][j - 1],
price[j] + prevDiff);
}
}

return profit[k][n - 1];
    }
}
