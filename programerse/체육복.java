package cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 체육복 {

	public List<Integer> node;
	public static int[] reserving;
	
	public static int solution(int n, int[] lost, int[] reserve) {
        reserving = new int[n+1];
        Arrays.fill(reserving, 1);
        for(int i=0;i<reserve.length;i++) {
        	reserving[reserve[i]]=2;
        }
        
        for(int i=0;i<lost.length;i++) {
        	if(reserving[lost[i]]==2) {
        		reserving[lost[i]]=1;
        	}
        	else {
        		reserving[lost[i]]=0;
        	}
        	
        }
        
        int count=0;
        //
        for(int i=1;i<reserving.length;i++) {
        	if(reserving[i]==1) {
        		count++;
        		continue;
        	}
        	
        	if(reserving[i]==2) {
        		count++;
        		
        		// 뒤
        		if(i!=1 && reserving[i-1]==0) {
        			count++;
        		}
        		// 앞
        		else if(i!=n && reserving[i+1]==0) {
        			reserving[i+1]=1;
        		}

        	}
        }
        
        
        return count;
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println(solution(5,new int[]{2,4} ,new int[]{3}));
	}
	
	

	

}
