//Q11.Given an unsorted array Arr of size N of positive integers. One number

         //'A' from     set {1, 2, …N} is missing and one number 'B'

        //occurs twice in array. Find these two numbers.
//Solution by Sakshi Gupta
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java
class Solve {
   int[] findTwoElement(int arr[], int n) {
       int res[]=new int[2];
       int xor=0;
       for(int i=1;i<=n;i++)
       {
           xor=xor^i^arr[i-1];
       }
       int res1=0,res2=0;
       int sn=xor & (~(xor-1));
       for(int i=0;i<n;i++)
       {
           if((arr[i]&sn)!=0)
           res1=res1^arr[i];
           else
           if((arr[i]&sn)==0)
           res2=res2^arr[i];
           if(((i+1) &sn)!=0)
           res1=res1^(i+1);
           else
           res2=res2^(i+1);
       }
       for(int i=0;i<n;i++)
       {
           if(arr[i]==res1)
           {
               res[0]=res1;
               res[1]=res2;
               return res;
           }
           else
           if(arr[i]==res2)
           {
               res[0]=res2;
               res[1]=res1;
               return res;
           }
       }
       res[0]=res2;
       res[1]=res1;
       return res;
   }
}
