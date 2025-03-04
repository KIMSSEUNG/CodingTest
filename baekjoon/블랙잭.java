package recursive;

import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 블랙잭 {
	static int N;
	static int M;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 0;
	
	static void recursive(int[] arr , int idx , int k  , int sum) {
		if(k==3) {
			if(sum <= M) {
				result = Math.max(result, sum);
			}
			return;
		}
		if(idx == N)return;
		recursive(arr , idx+1 , k+1 , sum+arr[idx]);
		recursive(arr , idx+1 , k , sum);
		
	}
	
	public static void main(String[] args)throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recursive(arr, 0 ,0,0);
		System.out.println(result);
		
	}

}
