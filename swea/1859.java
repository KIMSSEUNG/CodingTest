import java.io.*;
import java.util.*;

public class SSAFY {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int num = 1;
	static void logic() throws IOException{
		int N = Integer.parseInt(br.readLine());
		Long[] arr = new Long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken()); 
		}
		int l=0,r=N-1;
		int lP=0 , cP=0;
		Long result=0L;
		while(true) {
			if(l>=N)break;
			cP=0;
			lP=l;
			Long max = Long.MIN_VALUE;
			while(l<=r) {
				if(arr[l]>max) {
					cP=l;
					max =arr[l];
				}
				if(arr[r]>max) {
					cP=r;
					max =arr[r];
				}
				l++;r--;
				
			}
			//for문으로 더하고 팔기
			int sum=0;
			for(int i=lP;i<=cP;i++) {
				if(i==cP) {
					result+= arr[i]*(cP-lP)-sum;
				}
				sum+=arr[i];
			}
			l = cP+1;r=N-1;

			
		}
		System.out.println("#"+(num++)+" "+result);
		
	}
	
	public static void main(String[] args)throws IOException {
		int tC = Integer.parseInt(br.readLine());
		while(tC--!=0) {
			logic();
		}
	}
}

