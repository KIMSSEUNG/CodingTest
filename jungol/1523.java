import java.io.*;
import java.util.*;
//https://imgzon.tistory.com/140

public class SSAFY {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(n>100 || m>3|| m<1) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if(m==1) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else if(m==2) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else {
			int l=n-1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n+i;j++) {
					if(j>=l) {
						System.out.print("*");
					}
					else System.out.print(" ");
					
				}
				l--;
				System.out.println();
			}
		}
	}
}

