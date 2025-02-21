package recursive;

import java.util.*;
import java.io.*;

public class Solution {
    
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static int win ,lose;
	static int[] a;
	static int[] b;
	static int num=1;
	static int count=0;
	
	static void calcu(int[] storage) {
		int sumA=0,sumB=0;
		
		for(int i=0;i<9;i++) {
			if(a[i]>storage[i]) {
				sumA+=a[i]+storage[i];
			}
			else if(a[i]<storage[i]){
				sumB+=a[i]+storage[i];
			}
		}
		
		if(sumA>sumB) {
			win++;
		}
		else if(sumA<sumB) {
			lose++;
		}
	}
	
	static void recur(int k , int storage[] , boolean[] visit) {
		if(k==storage.length) {
			calcu(storage);
			return;
		}
		for(int i=0;i<storage.length;i++) {
			if(visit[i])continue;
			visit[i]=true;
			storage[k]=b[i];
			recur(k+1,storage,visit);
			visit[i]=false;
		}
	}	
	
	static void logic() throws Exception {
	    win=0;lose=0; 
		a = new int[9];
	     b = new int[9];
	     st = new StringTokenizer(br.readLine());
	     for(int i=0;i<9;i++) {
	    	 a[i] = Integer.parseInt(st.nextToken());
	     }
	     
	     int c =0;
	     for(int i=1;i<=18;i++) {
	    	 boolean isCheck=false;
	    	 for(int j=0;j<9;j++) {
	    		 if(a[j] == i) {
	    			 isCheck=true;
	    			 break;
	    		 }
	    	 }
	    	 if(isCheck==false) {
	    		 b[c]=i; c++;
	    	 }
	     }
	     
	     recur(0,new int[9],new boolean[9]);
	     System.out.println("#"+(num++)+" "+win+" "+lose);
	}
	
    public static void main(String[] args)throws Exception {
    	int tc =Integer.parseInt(br.readLine());
    	for(int i=0;i<tc;i++) {
    		logic();
    	}
    	

    }
}



