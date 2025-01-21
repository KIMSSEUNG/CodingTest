import java.io.*;
import java.util.*;
//https://imgzon.tistory.com/140

public class SSAFY {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if(n>100 || n%2==0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		int N = n/2;
		int num1 =1;
		int num2 = N-1;
		for(int i=0;i<n;i++) {
			if(i<=N) {
				for(int j=0;j<i;j++) {
					System.out.print(" ");
				}
				
				for(int j=0;j<num1;j++) {
					System.out.print("*");
				}
				if(i!=N)num1+=2;
				System.out.println();
			}
			else {
				num1-=2;
				for(int j=0;j<num2;j++) {
					System.out.print(" ");
				}
				
				for(int j=0;j<num1;j++) {
					System.out.print("*");
				}
				num2--;
				if(i!=n-1)System.out.println();
			}

		}
		
		
	}
}

