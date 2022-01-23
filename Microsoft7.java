//Q7.Unit Area of largest region of 1's
//Solution by Sakshi Gupta
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    int count;
    //Function to check if a given cell (row, col) can be included in DFS.
    static boolean isSafe(int[][] M,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //if the cell is within the matrix bounds and value at cell is 1 and
        //the cell is not visited, we return true else false.
        return ((row >= 0)&&(row<ROW)&&(col>=0)&& (col < COL)
                             && (M[row][col] == 1 && !visited[row][col]));
    }

    
    void DFS(int[][] M,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //these arrays are used to get row and column numbers
        //of 8 neighbours of a given cell.
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        //marking the current cell as visited.
        visited[row][col] = true;

        //iterating over the adjacent cells.
        for (int k = 0; k < 8; k++) 
        {
            //if cell indexes are within range, we increment the count
            //and call the function recursively.
            if (isSafe(M, row + dx[k], col + dy[k],visited, ROW, COL)) 
            {
                count++;
                DFS(M, row + dx[k], col + dy[k],visited, ROW, COL);
            }
        }
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int ROW = grid.length;
        int COL = grid[0].length;
        
        //using boolean array to mark visited nodes.
        boolean[][] visited = new boolean[ROW][COL];

        int result = 0;
        //traversing all the cells of the matrix.
        for (int i = 0; i < ROW; i++) 
        {
            for (int j = 0; j < COL; j++) 
            {
                //if a cell has value 1 is not visited, we call DFS function.
                if (grid[i][j] == 1 && !visited[i][j]) 
                {
                    count = 1;
                    DFS(grid, i, j, visited, ROW, COL);

                    //updating maximum area.
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}

