import java.util.Arrays;
import java.util.Scanner;

public class 피보나치수 {
	
	static int[] dp;
	
	static int fibo(int n) {
		if(n==1 || n==0) {
			return n;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		return dp[n]=fibo(n-1)+fibo(n-2);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		dp = new int[t+1];
		Arrays.fill(dp, -1);
		
		System.out.println(fibo(t));
	}
	
}
