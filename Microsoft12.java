//Q12.Find all the unique quadruple from the given array that sums up to the given number.
//Solution by Sakshi Gupta
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] A, int X) {
        // code here
        int l, r; 
  
     
        Arrays.sort(A); 
        int n = A.length;
         ArrayList<ArrayList<Integer>> list= new ArrayList<>();
      
        for (int i = 0; i < n - 3; i++)  
        { 
            // if (A[i] > 0 && A[i] > X) break;
       
        if (i > 0 && A[i] == A[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++)  
            { 
               
                if (j > i + 1 && A[j] == A[j - 1]) continue;
                
                l = j + 1; 
                r = n - 1; 
  
               
                while (l < r)  
                { 
                    int old_l = l;
                    int old_r = r;
                    if (A[i] + A[j] + A[l] + A[r] == X)  
                    { 
                       ArrayList<Integer> aList=new ArrayList<>();
                            aList.add(A[i]);
                            aList.add(A[j]);
                            aList.add(A[l]);
                            aList.add(A[r]);
                            list.add(aList);
                            
                            while (l < r && A[l] == A[old_l]) l++;
                    while (l < r && A[r] == A[old_r]) r--;
                            
                       
                    }  
                    else if (A[i] + A[j] + A[l] + A[r] < X) 
                        l++; 
                    else // A[i] + A[j] + A[l] + A[r] > X 
                        r--; 
                } 
            } 
        }
        return list;
    }
}
