//Q3.Find the missing no in string
//Solution by Sakshi Gupta
// { Driver Code Starts
import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int missingNumber(String s)
       {
       s=s.trim();
int len = s.length();
int k = (len/2);
int maxlen=String.valueOf(Integer.MAX_VALUE).length();
for(int i=1;i<=Math.min(k,maxlen);i++)
{
String data = s.substring(0,i);
int val = Integer.parseInt(data);
boolean missedOne = false;
int missedNumber=-1;
val++;
while(s.indexOf(data) > -1 && data.length() < len)
{
if(s.indexOf(data+val)==-1)
{
if(missedOne)break;
missedNumber=val;
missedOne=true;
}
else
data=data+val;
val++;
}
if(data.equals(s))return missedNumber;
}
return -1;
       }
}

