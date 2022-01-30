//Q13.Minimum Swaps to Arrange a Binary Grid
//Solution by Sakshi Gupta
class Solution {
    public int minSwaps(int[][] grid) {
   
    LinkedList<Integer> list = new LinkedList<>();
    int r = grid.length, c = grid[0].length;
    for (int i = 0; i < r; i++) {
        int count = 0;
        for (int j = c - 1; j >= 0; j--) {
            if (grid[i][j] != 0) break;
            count++;
        }
        list.add(count);
    }
    int res = 0;
    for (int i = 0; i < r; i++) {
        int t = -1;
      
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) >= (r - 1 - i)) {
                t = list.remove(j);
                res += j;
                break;
            }
        }
        if (t == -1) return -1;
    }
    return res;
}
}
