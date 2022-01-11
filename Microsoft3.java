//Q3.Rotate by 90 degree
//Solution by Sakshi Gupta
// { Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG
{
    static void rotate(int mat[][]) 
    {
        int N=mat.length;
        for (int x = 0; x < N / 2; x++) {

for (int y = x; y < N - x - 1; y++) {

int temp = mat[x][y];


mat[x][y] = mat[y][N - 1 - x];


mat[y][N - 1 - x]
= mat[N - 1 - x][N - 1 - y];

mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];


mat[N - 1 - y][x] = temp;
}
}
        // Code Here
    }
}
