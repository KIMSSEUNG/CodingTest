package recursive;

import java.util.*;
import java.io.*;

//손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
//코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 
//또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

public class 괄호짝짓기 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Scanner sc = new Scanner(System.in);
	static int num=1;
	
	static void logic() {
		int N = sc.nextInt();
		Stack<Character> s = new Stack<>();
		
		String t = sc.next();
		for(int i=0;i<N;i++) {
			s.add(t.charAt(i));
			while(true) {
				if(s.size()>=2) {
					char t2 = s.pop();
					char t1 = s.pop();
					if(t1=='[' && t2==']') continue;
					else if(t1 == '('&&t2==')')continue;
					else if(t1 == '<'&&t2=='>')continue;
					else if(t1 == '{'&&t2=='}')continue;
					s.add(t1);
					s.add(t2);
					break;
				}
				else {
					break;
				}
			}
		}
		System.out.println("#"+(num++)+" "+(s.size()==0?1:0));
	}
	
	public static void main(String[] args)throws IOException {
		int tc = 10;
		for(int i=0;i<tc;i++) {
			logic();
		}
	}
	

}
