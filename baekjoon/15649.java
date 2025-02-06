package recursive;

import java.io.*;
import java.util.*;

public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N , M;
	
	static void recursive(int[] arr , int[] storage ,  int k , boolean[] temp) {
		if(k==M) {
			for(int i=0;i<storage.length;i++) {
				System.out.print(storage[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!temp[i]) {
				temp[i]=true;
				storage[k] = arr[i];
				recursive(arr,storage,k+1,temp);
				temp[i]=false;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		boolean[] visit = new boolean[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		
		recursive(arr , new int[M] , 0 , visit);
	}

}
