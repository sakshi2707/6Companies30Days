//Q7.Capacity To Ship Packages Within D Days
//Solution by Sakshi Gupta
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        
        for(int weight: weights) {
            lo = Math.max(weight, lo);
            hi += weight;
        }
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(days(mid, weights) > days) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
    
    private int days(int capacity, int[] weights) {
        int counter = 0;
        int days = 1;
        
        for(int weight: weights) {
            if(counter + weight > capacity) {
                days++;
                counter = 0;
            }
            
            counter += weight;
        }
        
        return days;
    }
}

