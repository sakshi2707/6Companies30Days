//Q9.Pacific Atlantic Water Flow
//Solution by Sakshi Gupta
class Solution {
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];
        
        for(int i=0;i<col;i++) {
            dfs(matrix,0,i,Integer.MIN_VALUE,pacific);
            dfs(matrix,row-1,i,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i=0;i<row;i++) {
            dfs(matrix,i,0,Integer.MIN_VALUE,pacific);
            dfs(matrix,i,col-1,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                } 
            }
        }
        
        return res;
    }
    
    public void dfs(int matrix[][], int i, int j, int prev, boolean[][] ocean) {
        if(i<0 || i>=ocean.length || j<0 || j>= ocean[i].length) {
            return;
        }
        if(matrix[i][j] < prev || ocean[i][j]) {
            return;
        } 
        
        ocean[i][j] = true;
        
        for(int di[] : dir) {
            dfs(matrix,i+di[0], j+di[1],matrix[i][j],ocean);
        }
    }
}
