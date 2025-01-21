import java.io.*;
import java.util.*;

public class SSAFY {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] m = new int[100];
	static int num=1;
	
	static void logic()throws IOException {
		String in = br.readLine();
		boolean isZero = true;
		int count=0;
		for(int i=0;i<in.length();i++) {
			if(isZero && in.charAt(i)=='1') {
				isZero=false;
				count++;
			}
			if(!isZero && in.charAt(i)=='0') {
				isZero=true;
				count++;
			}
		}
		System.out.println("#"+(num++)+" "+count);
	}
	
	public static void main(String[] args)throws IOException {

		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			logic();
		}
	}
}

