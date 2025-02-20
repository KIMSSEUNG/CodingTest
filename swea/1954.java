package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이숫자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int num=1;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	
	static void logic()throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] m = new int[N][N];
		int ny=0,nx=-1;
		int count=1;
		int p=0;
		while(true) {
			if(count==(N*N)+1) {
				break;
			}
			ny+=dy[p];
			nx+=dx[p];
			if(ny<0||ny>=N||nx<0||nx>=N||m[ny][nx]!=0) {
				ny-=dy[p];nx-=dx[p];
				p++;p%=4;
				continue;
			}
			
			m[ny][nx]=count++;
		}
		
		
		System.out.println("#"+(num++));
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(j==N-1) {
					System.out.print(m[i][j]);
				}
				else {
					System.out.print(m[i][j]+" ");
				}
				
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		int tc= Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
	}
	
}
