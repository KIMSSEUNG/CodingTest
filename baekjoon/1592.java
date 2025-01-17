import java.util.*;

import java.io.*;

import java.lang.Math;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] p = new int[52];

    public static void main(String[] args)throws IOException
    {
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int L = Integer.parseInt(st.nextToken());
       int result=0;
       int point = 1;
       p[1]++;
       while(true){
           if(p[point]==M){
               break;
           }
           //던짐
           if(p[point]%2==1){
               //홀수
               point+=L;
               if(point>N){
                   point = point%N;
               }
               p[point]++;
           }
           else{
               //짝수
               point-=L;
               if(point<=0){
                   point = N+point;
               }
               p[point]++;
           }
           result++;
       }
       System.out.println(result);
    }
}