import java.io.*;
import java.util.*;

public class SSAFY {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[][] m = new int[105][105];
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args)throws IOException {

		int N = Integer.parseInt(br.readLine());
		int count =1;
		int p =0;
		int ny =0,nx = -1;
		while(count!=N*N+1) {
			int ty = dy[p]+ny;
			int tx = dx[p]+nx;
			if(ty<0 || ty>=N || tx<0 || tx>=N || m[ty][tx]!=0 ) {
				p++;
				p = p%4;
			}
			else {
				m[ty][tx]=count++;
				ny =ty;nx=tx;
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(j==N-1)System.out.print(m[i][j]);
				else System.out.print(m[i][j]+" ");
			}
			if(i!=N-1)System.out.println();
		}
		
	}
}

