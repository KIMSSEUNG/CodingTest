import java.io.*;
import java.util.*;

public class Algorism {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int num = 1;
	
	static void logic()throws IOException {
		int max = 0;
		int min = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]>arr[i+1]) {
				min = min>arr[i]-arr[i+1]?min:arr[i]-arr[i+1];
			}
			else if(arr[i]<arr[i+1]) {
				max = max>arr[i+1]-arr[i]?max:arr[i+1]-arr[i];
			}
		}
		
		System.out.println("#"+(num++)+" "+max+" "+min);
		
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int tc = Integer.parseInt(br.readLine());
		while(tc--!=0) {
			logic();
		}
	}

}
