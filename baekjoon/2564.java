import java.io.*;
import java.util.*;

public class SSAFY {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<String> l =new ArrayList<String>();
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		//데이터 셋
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			l.add(d+" "+c);
		}
		//// 플레이어 셋
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int result=0;
		for(int i=0;i<l.size();i++) {
			String[] t = l.get(i).split(" ");
			int sd = Integer.parseInt(t[0]);
			int sc = Integer.parseInt(t[1]);
			if(d==sd) {
				result+= Math.abs(sc-c);
			}
			else if((d==1&&sd==2) || (d==2&&sd==1)) {
				int t1=c+h+sc;
				int t2 = w-c+h+w-sc;
				result += t1<t2?t1:t2;
				continue;
			}
			else if((d==3&&sd==4) || (d==4&&sd==3)) {
				int t1=c+w+sc;
				int t2 = h-c+w+h-sc;
				result += t1<t2?t1:t2;
				
			}
			else if(d==1 || d==2) {
				if(sd==3) {
					result+=c;
					if(d==1) {
						result+=sc;
					}
					else {
						result+=h-sc;
					}
				}
				else {
					result+=w - c;
					if(d==1) {
						result+=sc;
					}
					else {
						result+=h-sc;
					}
				}
			}
			else {
				if(sd==1) {
					result+=c;
					if(d==2) {
						result+=sc;
					}
					else {
						result+=w-sc;
					}
				}
				else {
					result+=w - c;
					if(d==2) {
						result+=sc;
					}
					else {
						result+=w-sc;
					}
				}
			}
		}
		
		System.out.println(result);
		///// 시작
		
		
		
	}
}

