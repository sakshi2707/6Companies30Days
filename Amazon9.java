//Q9.Which among them forms a perfect Sudoku Pattern ?
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
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public int isValid(int mat[][]){
        int r[][]=new int[9][9];
        int c[][]=new int[9][9];
        int s[][][]=new int[3][3][9];
        
    
        int number;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] > 0 && mat[i][j] <= 9) {
                    number = mat[i][j] - 1;
                    if (r[i][number]!=0) 
                        return 0;
                    r[i][number] = 1;
                    if (c[j][number]!=0) 
                        return 0;
                    c[j][number] = 1;
                    // checking if same box have repeated value except for 0
                    if (s[i / 3][j / 3][number] !=0) 
                        return 0;
                    s[i / 3][j / 3][number] = 1;
                }
            }
        }
        return 1;
    }
};
