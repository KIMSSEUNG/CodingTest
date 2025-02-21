package recursive;

import java.util.*;
import java.io.*;

public class Solution {
    
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int win ,lose;
	static int[] a;
	static int[] b;
	static int num=1;
	static int count=0;
		
	
	static void logic() throws Exception {
	    num = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    Deque<Integer> dq = new ArrayDeque<>();
	    for(int i=0;i<8;i++) {
	    	dq.addLast(Integer.parseInt(st.nextToken()));
	    }
	    int count =1;
	    while(true) {
	    	int temp = dq.pollFirst();
	    	temp-=count;
	    	if(temp<=0) {
	    		dq.addLast(0);
	    		break;
	    	}
	    	dq.addLast(temp);
	    	count++;count%=6;
	    	if(count==0)count=1;
	    }
	    
	    System.out.print("#"+num+" ");
	    for(int i=0;i<8;i++) {
	    	if(i==7) {
	    		System.out.print(dq.pollFirst());
	    	}
	    	else {
	    		System.out.print(dq.pollFirst()+" ");
	    	}
	    }
	    System.out.println();
	    
	}
	
    public static void main(String[] args)throws Exception {
    	int tc =10;
    	for(int i=0;i<tc;i++) {
    		logic();
    	}
    	

    }
}



