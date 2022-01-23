//Q5.Stock span problem
//Solution by Sakshi Gupta
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends




class Solution{
    
    // Function to calculate span
    // price[]: input array
    public static int[] calculateSpan(int price[], int n)
    {
        int[] a=new int[n];
        Deque<Integer> st=new ArrayDeque<>();
        st.push(0);
        
        a[0]=1;
        for(int i=1;i<n;i++){
            while(st.isEmpty()==false && price[st.peek()]<=price[i])
            { 
             st.pop();
                
            }
            a[i]=st.isEmpty()?i+1:i-st.peek();
            
            st.push(i);
        }
        return a;
        // Your code here
    }
    
}
