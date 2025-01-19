import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int testCase = 0;
    static int num = 1;
    //3으로 나눈 후 나온 값에 *3 이면 왼쪽 위 , +2씩 해주면 오른쪽 아래 좌표

    static void logic() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int v=0;
        int m =0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int velocity=0;
            if(a!=0)velocity = Integer.parseInt(st.nextToken());
            if(a==1){
                //연산
                v+=velocity;
                m+=v;
                //더하기
            }
            else if(a==2){
                v = v-velocity<=0?0:v-velocity;
                m+=v;
            }
            else{
                m+=v;
            }

        }
        System.out.println("#"+(num++)+" "+m);
    }

    public static void main(String[] args)throws IOException {
        testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            logic();
        }

    }
}