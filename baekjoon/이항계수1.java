import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 이항계수1 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		// n!/(n-k)!k! => nCk 이항 계수
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int mo =1;
		for(int i=n;i>=1;i--) {
			mo*=i;
		}
		
		int ja=1;
		for(int i=(n-k);i>=1;i--) {
			ja*=i;
		}

		for(int i=k;i>=1;i--) {
			ja*=i;
		}
		
		System.out.println(mo/ja);
		
	}
	
}
