package recursive;

import java.io.*;
import java.util.*;

//구역은 1번부터 N번까지 번호가 매겨져 있다. 
//

public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int m[][] = new int[101][101];
	static int node[][] = new int[101][101];
	static int adj[][] = new int[101][101];
	static int result = 0;
	static int N=0 , M=0;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	//node 정의
	static void dfs(int y , int x , int dir) {
		node[y][x] =dir;
		for(int i=0;i<4;i++) {
			int ny = dy[i]+y;
			int nx = dx[i]+x;
			if(ny<0||ny>=N||nx<0||nx>=M||node[ny][nx]!=0)continue;
			if(m[ny][nx]!=1)continue;
			dfs(ny,nx,dir);
		}
	}
	
	
	static void search(int y , int x , int c) {
		//1
		int count=0;
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			count=0;
			while(true) {
				if(ny<0||ny>=N||nx<0||nx>=M)break;
				if(node[ny][nx]==0) {
					ny+=dy[i];
					nx+=dx[i];
					count++;
					continue;
				}
				if(node[ny][nx]==c) {
					count = 0;break;
				}
				if(node[ny][nx]!=c) {
					if(count>1) {
						if(adj[c][node[ny][nx]]==0)adj[c][node[ny][nx]] =count;
						else if(adj[c][node[ny][nx]]>count)adj[c][node[ny][nx]] =count;
					}
					break;
				}
			}


		}
	}
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int c= 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j]==1 && node[i][j]==0) {
					dfs(i,j,c);
					c++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(node[i][j]!=0) {
					search(i,j,node[i][j]);
				}
			}
		}
		
		int check = 0;
		//검증
		if(c==1) {
			System.out.println(-1);
			return;
		}
			
		
		int[] dist = new int[c];
		boolean[] v = new boolean[c];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1]=0;
		//프릴 알고리즘
		for(int i=1;i<=c-2;i++){
			int node=1;
			int d = Integer.MAX_VALUE;
			for(int j=1;j<=c-1;j++) {
				if(!v[j] && dist[j]<d) {
					node=j;
					d= dist[j];
				}
			}
			
			v[node] = true;
			for(int j=1;j<=c-1;j++) {
				if(adj[node][j]!=0 && !v[j] && adj[node][j]<dist[j]) {
					dist[j] = adj[node][j];
				}
			}
			
		}
		int result =0;
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			result+=dist[i];
		}
		
		System.out.println(result);
		
		
		
	}

}
