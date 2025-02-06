package recursive;

import java.io.*;
import java.util.*;

public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N , M;
	
	static void recursive(int[] arr , int[] storage , int idx , int k ) {
		
		
		if(k==M) {
			for(int i=0;i<storage.length;i++) {
				System.out.print(arr[storage[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		if(idx==N)return;
		
		storage[k] = idx;
		recursive(arr,storage , idx+1 , k+1);
		recursive(arr,storage , idx+1 , k);
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		
		recursive(arr , new int[M] , 0 , 0 );
	}

}
