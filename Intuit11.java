//Q11.Construct Quad Tree
//Solution by Sakshi Gupta

class Solution {
    long[][] prefixSum;
    public Node construct(int[][] grid) {
        
        int n = grid.length;
        prefixSum = new long[n+1][n+1];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                prefixSum[i+1][j+1] = prefixSum[i][j+1]+prefixSum[i+1][j]+(long)grid[i][j]-prefixSum[i][j];
            }
        }
        
        Node root = construct(0,0,n-1,n-1);
        return root;
    }
    
    private Node construct(int r1, int c1, int r2, int c2){
        Node node = new Node();
        boolean isAllOne = allOne(r1,c1,r2,c2);
        if(isAllOne){
            node.val = true;
            node.isLeaf = true;
            return node;
        }
        boolean isAllZero = allZero(r1,c1,r2,c2);
        if(isAllZero){
            node.val = false;
            node.isLeaf = true;
            return node;
        }
        int midR = r1+(r2-r1)/2;
        int midC = c1+(c2-c1)/2;
        
        node.topLeft = construct(r1,c1,midR,midC);
        
        node.topRight = construct(r1,midC+1,midR,c2);
        
        node.bottomLeft=construct(midR+1,c1,r2,midC);
        
        node.bottomRight = construct(midR+1,midC+1,r2,c2);
        return node;
    }
    
    private boolean allOne(int r1, int c1, int r2, int c2){
        long total = ((long)(r2-r1+1))* (c2-c1+1);
        
        long val = prefixSum[r2+1][c2+1]-prefixSum[r1][c2+1] -prefixSum[r2+1][c1]+prefixSum[r1][c1];
        
        return val==total;
    }
    
    private boolean allZero(int r1, int c1, int r2, int c2){
        long val = prefixSum[r2+1][c2+1]-prefixSum[r1][c2+1] -prefixSum[r2+1][c1]+prefixSum[r1][c1];
        return val==0l;
    }
}
