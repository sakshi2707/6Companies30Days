//Q3.Remove Colored Pieces if Both Neighbors are the Same Color
//Solution by Sakshi Gupta
class Solution {
     public static boolean winnerOfGame(String colors) {
        int AlicePossibleMoves = 0, BobPossibleMoves = 0;
        
        
        for(int i = 0; i < colors.length(); i++) {
            int curCount = -2;
            int j = i;
            if(colors.charAt(i) == 'A') {
                while(j < colors.length() && colors.charAt(j) == 'A') {
                    j++;
                    curCount++;
                }
                AlicePossibleMoves += curCount > 0? curCount : 0;
            }
            
            else{
                while(j < colors.length() && colors.charAt(j) == 'B') {
                    j++;
                    curCount++;
                }
                BobPossibleMoves += curCount > 0? curCount : 0;
                
            }
            i += curCount > 0? curCount : 0;
        }
        
        return AlicePossibleMoves > BobPossibleMoves;
    }   
}
