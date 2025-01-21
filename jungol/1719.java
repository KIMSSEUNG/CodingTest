import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(n>100 || n%2==0 || m==0 || m>4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int N = n/2;
		if(m==1) {
			for(int i=0;i<n;i++) {
				if(i<=N) {
					for(int j=0;j<=i;j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				else{
					for(int j=0;j<=n-i-1;j++) {
						System.out.print("*");
					}
					if(i!=n-1)System.out.println();
				}
			}
		}
		else if(m==2) {
			int count=1;
			for(int i=0;i<n;i++) {
				if(i<=N) {
					for(int j=0;j<=N-i-1;j++) {
						System.out.print(" ");
					}
					
					for(int j=0;j<=i;j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				else{
					for(int j=0;j<count;j++) {
						System.out.print(" ");

					}
					
					for(int j=i;j<n;j++) {
						System.out.print("*");
					}
					count++;
					if(i!=n-1)System.out.println();
				}
			}
		}
		else if(m==3) {
			int count=N-1;
			int num=0;
			for(int i=0;i<n;i++) {
				if(i<=N) {
					for(int j=0;j<i;j++) {
						System.out.print(" ");
					}
					
					for(int j=0;j<n-(i*2);j++) {
						System.out.print("*");
					}
					
					for(int j=0;j<i;j++) {
						System.out.print(" ");
					}
					System.out.println();
				}
				else{
					for(int j=0;j<count;j++) {
						System.out.print(" ");
					}
					
					for(int j=0;j<3+2*num;j++) {
						System.out.print("*");
					}
					
					for(int j=0;j<count;j++) {
						System.out.print(" ");
					}
					num++;count--;
					if(i!=n-1)System.out.println();
				}
			}
		}
		else{
			for(int i=0;i<n;i++) {
				if(i<=N) {
					for(int j=0;j<i;j++) {
						System.out.print(" ");
					}
					for(int j=0;j<=N-i;j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				else {
					for(int j=0;j<N;j++) {
						System.out.print(" ");
					}
					
					for(int j=0;j<=i-N;j++) {
						System.out.print("*");
					}
					if(i!=n-1)System.out.println();
				}
			}
		}
		
		
	}
}

