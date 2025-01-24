import java.io.*;
import java.util.*;

public class Algorism {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int num = 1;
	
	static void logic()throws IOException {
		int max = 0;
		int player = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			int lc=0;
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t==1) {
					lc++;
				}
			}
			if(lc>max) {
				player=1;
				max=lc;
			}
			else if(lc==max) {
				player++;
			}
		}
		
		System.out.println("#"+(num++)+" "+player+" "+max);
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int tc = Integer.parseInt(br.readLine());
		while(tc--!=0) {
			logic();
		}
	}

}
