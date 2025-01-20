import java.io.*;
import java.util.*;


public class main {

	
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src\\test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"\\");
		System.out.println(st.nextToken());
	}

}
