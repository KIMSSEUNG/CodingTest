import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 피보나치수2 {
	
	static long[] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long fibo(int n) {
		if(n==1 || n==0) {
			return n;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		return dp[n]=fibo(n-1)+fibo(n-2);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int t = Integer.parseInt(br.readLine());

		dp = new long[t+1];
		Arrays.fill(dp, -1);
		
		System.out.println(fibo(t));
	}
	
	
}
