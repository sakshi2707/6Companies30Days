//Q15.Divide Two Integers
//Solution by Sakshi Gupta
class Solution {
    public int divide(int dividend, int divisor) {
          long dd = dividend;
        long dr = divisor;

        boolean neg = dd < 0 != dr < 0;

        if (dd < 0) dd = -dd;
        if (dr < 0) dr = -dr;

        long result = divideLong(dd, dr);
        return neg ? result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -result : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    public long divideLong(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long ans = 1;
        long sum = divisor;
        while ((sum + sum) <= dividend) {
            sum += sum;
            ans += ans;
        }

        return ans + divideLong(dividend - sum, divisor);
        
    }
}
