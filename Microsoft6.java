//Q6.Possible Words From Phone Digits
//Solution by Sakshi Gupta
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{static String codes[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        if(N == 0)
{
ArrayList<String> allWords = new ArrayList<>();
allWords.add("");
return allWords;
}

String code = codes[a[0] - 2];

int smallerInput[] = Arrays.copyOfRange(a, 1, N);
ArrayList<String> words = possibleWords(smallerInput, N - 1);

ArrayList<String> allWords = new ArrayList<>();

for(int i = 0; i < code.length(); i++)
{
for(String word : words)
{
allWords.add(code.charAt(i) + word);
}
}

return allWords;
    }
}

