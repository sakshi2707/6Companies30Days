//Q1.Find a continuous sub-array which adds to a given number S
//Solution by Sakshi Gupta
import java.io.*;

class Array{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Subarray obj = new Subarray();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends



class Subarray{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
        
        // Your code here
  ArrayList<Integer> list=new ArrayList<Integer>();
int curr_sum = arr[0], start = 0, i;


for (i = 1; i <= n; i++) {

while (curr_sum > sum && start < i - 1) {
curr_sum = curr_sum - arr[start];
start++;
}
if (curr_sum == sum) {
list.add(start+1);
list.add(i);
return list;
}
if (i < n)
curr_sum = curr_sum + arr[i];

}

list.add(-1);

return list; 
        
    }
}
