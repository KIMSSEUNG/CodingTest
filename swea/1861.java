package recursive;

import java.io.*;
import java.util.*;

public class 정사각형방 {
	
	static class pair{
		int y;
		int x;
		int c;
		public pair(int y, int x , int c) {
			this.y =y;
			this.x = x;
			this.c =c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m[][];
	static int N;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int num=1;
	
	static void logic()throws Exception {
		N = Integer.parseInt(br.readLine());
		m = new int[N][N];
		int idx = Integer.MAX_VALUE;
		int result=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int s=0;s<N;s++) {
			for(int j=0;j<N;j++) {
				Queue<pair> q =new LinkedList<>();
				q.add(new pair(s,j,1));
				while(!q.isEmpty()) {
					pair p = q.poll();
					if(result< p.c) {
						result = p.c;
						idx = m[s][j];
					}
					else if(result == p.c) {
						idx = Math.min( idx, m[s][j]);
					}
					for(int i=0;i<4;i++) {
						int ny = dy[i]+p.y;
						int nx = dx[i]+p.x;
						if(ny<0||ny>=N||nx<0||nx>=N)continue;
						if((m[ny][nx]-m[p.y][p.x])!=1)continue;
						q.add(new pair(ny,nx,p.c+1));
					}
				}
			}
		}
		
		System.out.println("#"+(num++)+" "+idx+" "+result);
		

	}
	
	public static void main(String[] args)throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
	}
}
