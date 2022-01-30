//Q14.As Far from Land as Possible
//Solution by SAkshi Gupta
class Solution {
    class Pair{
        int i,j,dist;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public boolean valid(int x,int y,int [][]grid){
        if(x<0 || y <0 || x>=grid.length || y>=grid.length || grid[x][y]!=0)return false;
        return true;
    }
    public int maxDistance(int[][] grid) {
        int n=grid.length,water=0,land=0;
        Queue<Pair>q=new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    grid[i][j]=-2; 
                    land++;
                }else water++;
            }
        }
        if(water==n*n || land==n*n)return -1;
        int max=0;
        int [][]directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int i=0;i<directions.length;i++){
                int x=p.i+directions[i][0];
                int y=p.j+directions[i][1];
                if(valid(x,y,grid)){
                    Pair p1=new Pair(x,y);
                    p1.dist=p.dist+1;
                    max=Math.max(p1.dist,max);
                    q.add(p1);
                    grid[x][y]=-2;
                }
            }
        }
        return max;
    }
}
