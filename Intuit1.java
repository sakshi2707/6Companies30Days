//Q1.Partition a set into two subsets such that the difference of subset sums is minimum
//Solution by Sakshi Gupta
import java.util.*;
 
class Solution {
 
    static int minDifference(int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        int y = sum / 2 + 1;
       
        boolean dp[] = new boolean[y], dd[]
                                       = new boolean[y];
 
        // Initialising dp and dd
        for (int i = 0; i < y; i++) {
            dp[i] = dd[i] = false;
        }
 
        
        dd[0] = true;
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j + arr[i] < y; j++) {
                if (dp[j])
                    dd[j + arr[i]] = true;
            }
            
            for (int j = 0; j < y; j++) {
                if (dd[j])
                    dp[j] = true;
                dd[j] = false; // reset dd
            }
        }
      
 
        for (int i = y - 1; i >= 0; i--) {
            if (dp[i])
                return (sum - 2 * i);
           
        }
        return 0;
    }
 
    public static void main(String[] args)
    {
 
        int arr[] = { 1, 6, 11, 5 };
        int n = arr.length;
        System.out.print(
            "The Minimum difference of 2 sets is "
            + minDifference(arr, n) + '\n');
    }
}
