//Q7. Find the kid which gets tha damaged toy
//Solution by Sakshi Gupta
import java.util.*;
class GFG {
 
   
    static int lastPosition(int n, int m, int k)
    {
 
       
        if (m <= n - k + 1)
            return m + k - 1;
 
   
        m = m - (n - k + 1);
 
        
        return (m % n == 0) ? n : (m % n);
    }
 
    // Driver Program to test above function
    public static void main(String arg[])
    {
    Scanner sc=new Scanner(System.in);
    
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(lastPosition(n, m, k));
    }
}
