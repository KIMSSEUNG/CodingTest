package recursive;

import java.util.*;
import java.io.*;

public class 배열돌리기1 {
    
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,R;
	static int[][] m;
		
	
    public static void main(String[] args)throws Exception {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	m = new int[N][M];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			m[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	
    	for(int i=0;i<R;i++) {
    		int y=0, x=0;
    		int tN = N , tM = M;
    		while(tN != 0 && tM !=0) {
    			spin(y,x , tN , tM);
    			tN-=2;tM-=2;
    			y++;x++;
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			System.out.print(m[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,1,0,-1};
    static public void spin(int py , int px, int row , int column) {
    	int sto = m[py][px];
    	int p=0;
    	while(p<4) {
    		if(p==1 || p==3) {
        		for(int i=0;i<column-1;i++) {
            		if(p==4)break;
            		py+=dy[p];
            		px+=dx[p];
            		int temp = m[py][px];
            		m[py][px] = sto;
            		sto=temp;
            	}
        		p++;
        	}
        	else {
        		for(int i=0;i<row-1;i++) {
            		if(p==4)break;
            		py+=dy[p];
            		px+=dx[p];
            		int temp = m[py][px];
            		m[py][px] = sto;
            		sto=temp;
            	}
        		p++;
        	}
    	}
    }
}




