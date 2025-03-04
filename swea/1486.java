package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,B;
	static Integer[] arr;
	static int num=1;
	static int result;
	
	static void combi(int idx , int res) {
		if(res >=B) {
			result = Integer.min(result, res-B);
		}
		if(idx==N)return;
		
		combi(idx+1 , res+arr[idx]);
		combi(idx+1 , res);
	}
	
	static void logic()throws Exception {
		result=Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0,0);
		
		System.out.println("#"+(num++)+" "+result);
	}
	
	public static void main(String[] args)throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
	}
}
