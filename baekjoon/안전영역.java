package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 안전영역 {
	static class pair{
		int y=0;
		int x=0;
		public pair(int y , int x){
			this.y=y;
			this.x=x;
		}
	}
	
	static int N;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 0;
	static int arr[][];
	static int visit[][];
	static int max;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void bfs(int y , int x,int s) throws Exception{
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(y,x));
		visit[y][x]=s;
		while(!q.isEmpty()) {
			pair p = q.poll();
			for(int i=0;i<4;i++) {
				int ny = p.y +dy[i];
				int nx = p.x +dx[i];
				if(ny<0||ny>=N||nx<0||nx>=N)continue;
				if(visit[ny][nx]==s)continue;
				if(arr[ny][nx]<=s)continue;
				visit[ny][nx]=s;
				q.add(new pair(ny,nx));
			}
		}

	}
	
	public static void main(String[] args)throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for(int i=0;i<visit.length;i++) {
			Arrays.fill(visit[i], -1);
		}
		
		for(int s=0;s<=max;s++) {
			int localC=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]<=s)continue;
					if(visit[i][j]==s)continue;
					localC++;
					bfs(i,j,s);
				}
			}
			result = Math.max(result, localC);
		}
		System.out.println(result);
		
		
	}

}
