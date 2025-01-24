import java.io.*;
import java.util.*;

public class Algorism {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int num = 1;
	
	static void logic()throws IOException {
		
		int[][] m = new int[9][9];
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				//가로
				for(int s =0;s<9;s++) {
					if(j==s)continue;
					if(m[i][j]==m[i][s]) {
						System.out.println("#"+(num++)+" "+0);
						return;
					}
				}
				//세로
				for(int s =0;s<9;s++) {
					if(i==s)continue;
					if(m[i][j]==m[s][j]) {
						System.out.println("#"+(num++)+" "+0);
						return;
					}
				}
				//전체
				int y=0 ,x=0 , ny=0 , nx=0;
				y=i/3*3; x=j/3*3;
				ny = y+2;nx=x+2;
				for(int h =y;h<=ny;h++) {
					for(int w =x;w<=nx;w++) {
						if(i==h && j==w)continue;
						if(m[i][j]==m[h][w]) {
							System.out.println("#"+(num++)+" "+0);
							return;
						}
					}
				}
			}
		}
		System.out.println("#"+(num++)+" "+1);
		return;

	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int tc = Integer.parseInt(br.readLine());
		while(tc--!=0) {
			logic();
		}
	}

}
