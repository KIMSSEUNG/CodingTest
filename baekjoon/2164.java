import java.io.*;
import java.util.*;

public class SSAFY {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	
	public static void main(String[] args)throws IOException {
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.poll();
			int temp =q.poll();
			q.add(temp);
		}
		
		System.out.println(q.poll());
		
		
	}
	

}

