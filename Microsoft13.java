//Q13.Given a Graph of V vertices and E edges and another edge(c - d), the task is to find if the given edge is a Bridge. i.e., removing the edge disconnects the graph.
//Solution by Sakshi Gupta
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution 
{
   
    void DFS(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[]) 
    {
        
        visited[v] = true;
        
       
        for (int i = 0; i < adj.get(v).size(); ++i)
        
            if (!visited[adj.get(v).get(i)])
                DFS(adj, adj.get(v).get(i), visited);
    }
    
  
    boolean isConnected(ArrayList<ArrayList<Integer>> adj,int V,int one,int two)
    {
        
        boolean visited[] = new boolean[V];
        
        
        DFS(adj, one, visited);
        
      
        if (visited[two] == false)
            return false;
        return true;
    }
    
   
    public int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d) 
    {
        
        if (!isConnected(adj, V, c, d))
            return 0;
        else
        {
          
            adj.get(c).remove(new Integer(d));
            adj.get(d).remove(new Integer(c));
            
         
            if (isConnected(adj, V, c, d))
                return 0;
            else
                return 1;
        }
    }
}

