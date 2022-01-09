//Q13.Rotten Oranges
//Solution by Sakshi Gupta
class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid==null|| grid.length==0)return 0;
        
        int rows=grid.length,cols=grid[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        int cf=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2)q.offer(new int[]{i,j});
                if(grid[i][j]!=0)cf++;
            }
        }
        
        if(cf==0)return 0;
        int countMin=0,cnt=0;
        int x[]={0,0,1,-1};
        int y[]={1,-1,0,0};
        
        while(!q.isEmpty()){
            int n=q.size();
            
            cnt+=n;
            for(int i=0;i<n;i++){
                int[] point=q.poll();
                for(int j=0;j<4;j++){
                    int xi=point[0]+x[j];
                    int yi=point[1]+y[j];
                    
                    if(xi<0 || yi<0|| xi>=rows || yi>=cols || grid[xi][yi]==0|| grid[xi][yi]==2)continue;
                    
                    grid[xi][yi]=2;
                    q.offer(new int[]{xi,yi});
                }
            }
            
            if(q.size()!=0)countMin++;
            
        }
        return cf==cnt?countMin:-1;
        
    }
}
