//Q11.Generate and print all binary numbers with decimal values from 1 to N.  
//Solution by Sakshi Gupta
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //Taking input using class Scanner 
        Scanner sc = new Scanner(System.in);
        
        //Taking the number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking the range
            int n = sc.nextInt();
            
            //creating an ArrayList
            ArrayList<String> res = new ArrayList<String>();
            
            //calling the generate method of class solve
            //and storing the result in an ArrayList
            res = new solve().generate(n);
            
            //printing all the elements of the ArrayList
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends





class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int n)
    {        Deque<String> q = new ArrayDeque<>();
        ArrayList<String> a = new ArrayList<>();
        q.offer("1");
        while (n-- > 0) {
            String s = q.poll();
            a.add(s);
            q.offer(s + "0");
            q.offer(s + "1");
        }
        return a;

        // Your code here
    }
    
}
