import java.io.*;
import java.util.*;

public class SSAFY {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] m = new int[100];
	static int num=1;
	
	static void logic()throws IOException {
		int d = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<100;i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<d;i++) {
			int maxVal = Integer.MIN_VALUE;
			int minVal = Integer.MAX_VALUE;
			int minNum=0 , maxNum=0;
			for(int j=0;j<100;j++) {
				int temp = m[j];
				if(temp>maxVal) {
					maxVal = temp;
					maxNum=j;
				}
				if(temp<minVal) {
					minVal = temp;
					minNum=j;
				}
			}
			m[maxNum]--;m[minNum]++;
		}
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for(int j=0;j<100;j++) {
			int temp = m[j];
			if(temp>maxVal) {
				maxVal = temp;
			}
			if(temp<minVal) {
				minVal = temp;
			}
		}
		System.out.println("#"+(num++)+" "+(maxVal-minVal));
	}
	
	public static void main(String[] args)throws IOException {

		for(int i=0;i<10;i++) {
			logic();
		}
	}
}

