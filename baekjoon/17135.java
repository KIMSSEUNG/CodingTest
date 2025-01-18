import java.io.*;
import java.util.*;

public class Main {

	static class Pair{
		public int y=0;
		public int x=0;
		Pair(int a , int b){
			this.y = a;
			this.x = b;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int testCase = 0;
	static int num=1;
	static int N=0,M=0,D=0;
	static int[][] m = new int[19][19];
	static List<Pair[]> com = new ArrayList<>();

	static void combi(List<Pair> l , int point) {
		if(l.size()==3) {
			com.add(l.toArray(new Pair[0]));
			return;
		}
		for(int i=point;i<M;i++) {
			var temp =new Pair(N,i);
			l.add(temp);
			combi(l,i+1);
			l.remove(temp);
		}
	}

	static void logic() throws IOException{
		//초기화
		for(int i=0;i<m.length;i++) {
			Arrays.fill(m[i], 0);
		}
		List<Pair> e =new ArrayList<>();
		combi(new ArrayList<Pair>(),0);

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if(m[i][j]==1) {
					e.add(new Pair(i,j));
				}
			}
		}
		int result=0;

		for(int i=0;i<com.size();i++) {
			List<Pair> temp = new ArrayList<>();
			for(int j=0;j<e.size();j++) {
				var t = e.get(j);
				temp.add(new Pair(t.y,t.x));
			}

			var c = com.get(i);
			int localResult=0;

			while(temp.size()!=0) {
				List<Pair> removed = new ArrayList<>();

				//궁수 쏘기
				for(int j=0;j<c.length;j++) {
					Pair num = new Pair(-1,100);
					int minlength = 1000;
					for(int s=0;s<temp.size();s++) {
						var t = temp.get(s);
						var leng = Length(c[j].y , c[j].x , t.y ,t.x);
						if(leng>D)continue;

						if(leng>minlength)continue;

						if(minlength==leng) {
							if(t.x>=num.x)continue;
							num=t;
						}
						else {
							num=t;
							minlength=leng;
						}

					}
					if(num.y ==-1)continue;
					removed.add(num);
				}


				//제거
				for(int j=0;j<removed.size();j++) {
					if(!temp.contains(removed.get(j)))
						continue;
					temp.remove(removed.get(j));
					localResult++;
				}

				//이동
				for(int j=0;j<temp.size();j++) {
					var t = temp.get(j);
					t.y++;
					if(t.y>=N) {
						temp.remove(t);
						j--;
					}
				}

			}
			result = result>localResult?result:localResult;
			temp.clear();
		}
		System.out.println(result);
		//result
	}

	static int Length(int y1 , int x1 , int y2 , int x2) {
		return Math.abs(y1-y2)+Math.abs(x1-x2);
	}

	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		logic();
	}
}