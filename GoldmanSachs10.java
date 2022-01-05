//Q10. Find max 10 numbers in a list having 10M entries.
//Solution by Sakshi Gupta
import java.util.*;


class Solution{   

    public int[] max10Elements(int[] entries){
        int mx = 10;
        int[] result=new int[mx];
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: entries){
            maxHeap.add(i);
            if(maxHeap.size() > mx)
                maxHeap.remove(i);
        }

        for(int i=0; i<mx; i++){
            int top = maxHeap.peek();
            maxHeap.poll();
            result[i] = top;
        }
        return result;
    }
}
