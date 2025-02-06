package recursive;

import java.io.*;
import java.util.*;

public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N , M;
	static StringBuffer sb = new StringBuffer();
	static void recursive(int[] arr , int[] storage , int k ) {
		if(k==M) {
			
			for(int i=0;i<storage.length;i++) {
				sb.append(storage[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			storage[k] = arr[i];
			recursive(arr, storage , k+1);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		
		recursive(arr , new int[M] , 0 );
		System.out.println(sb.toString());
	}

}
