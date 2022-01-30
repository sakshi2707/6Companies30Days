//Q11.String Amendment
//Solution by Sakshi Gupta
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public void amendSentence(String s){
        //code here
        char[] str=sstr.toCharArray();
         
        
        for (int i=0; i < str.length; i++)
        {
            
            if (str[i]>='A' && str[i]<='Z')
            {
                str[i] = (char)(str[i]+32);
                 
              
                if (i != 0)
                    System.out.print(" ");
     
               
                System.out.print(str[i]);
            }
     
          
            else
            System.out.print(str[i]);
    }
}


