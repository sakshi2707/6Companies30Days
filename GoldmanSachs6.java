/**Q6. Given two strings str1 and str2. We say that str2 divides str1 if it's possible

            to          concatenate multiple str2 to get str1. For example, ab divides abab.

           if str2 does not divide str1, return -1. Otherwise, return the smallest string**\
 //Solution by Sakshi Gupta  
 // { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
      Scanner sc=new Scanner(System.in);
      String s1=sc.next();
      String s2=sc.next();
      Solution s=new Solution();
      String ans=s.gcdOfStrings(s1,s2);
      System.out.println(ans);
    }
}
 class Solution {
     public String gcdOfStrings(String str1, String str2) {
    /*
    T: O(n/m* (n-m)) or O(n/m)
    S: O(n/m)
    */
        int size1 = str1.length();
        int size2 = str2.length();
        if(size2>size1)  return gcdOfStrings(str2,str1);
        if(size1 == size2){
            if(str1.equals(str2)) return str1;
            else return "";
        }
        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()),str2);
        } else return "";
    }

}          
           
