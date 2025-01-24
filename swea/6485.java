import java.io.*;
import java.util.*;

public class Algorism {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int num = 1;
	
	static void logic()throws IOException {
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[5001];
		Arrays.fill(arr, 0);
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int bi = Integer.parseInt(st.nextToken());
			for(int j=ai;j<=bi;j++) {
				arr[j]++;
			}
		}
		
		int P = Integer.parseInt(br.readLine());
		String result="";
		for(int i=0;i<P;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(i==P-1) {
				result+=arr[temp];
				break;
			}
			result+=arr[temp]+" ";
		}
		
		System.out.println("#"+(num++)+" "+result);
	}
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int tc = Integer.parseInt(br.readLine());
		while(tc--!=0) {
			logic();
		}
	}

}
