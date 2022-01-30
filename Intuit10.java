//Q10. Number of Provinces
//Solution by Sakshi Gupta
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < isConnected.length; i++)
        {
            alist.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    alist.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[alist.size() + 1];
        for(int i = 0; i < alist.size(); i++)
        {
            if(visited[i] == false)
            {
                ans++;
                bfs(alist, i, visited);
            }
        }
        return ans;
    }
    public void bfs(ArrayList<ArrayList<Integer>> alist, int v, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty())
        {
            int x = q.poll();
            for(int y : alist.get(x))
            {
                if(visited[y] == false)
                {
                    visited[y] = true;
                    q.add(y);
                }
            }
        } 
    }
}
