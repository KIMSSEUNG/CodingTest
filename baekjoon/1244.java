import java.io.*;
import java.util.*;

public class SSAFY {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] sw = new int[101];
	
	public static void main(String[] args)throws IOException {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int c = Integer.parseInt(br.readLine());
		
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(m==1) {
				//곱셈
				int count=1;
				for(int j=x;j<=n;j=x*count) {
					sw[j] = sw[j]==1?0:1;
					count++;
				}
			}
			else {
				//투포인터
				int l=x , r=x;
				while(true) {
					//조건
					if(l<1 || r>n || sw[l]!=sw[r])
						break;
					if(l==r) {
						sw[l] = sw[l]==1?0:1;
					}
					else {
						sw[l] = sw[l]==1?0:1;
						sw[r] = sw[r]==1?0:1;
					}
					
					//플러스 마이너스
					l--;r++;
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(i==n) {
				System.out.print(sw[i]);
			}
			else {
				System.out.print(sw[i]+" ");
			}
			if(i%20==0) {
				System.out.println();
			}
			
		}
		
	}
}

