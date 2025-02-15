import java.util.*;
import java.io.*;

public class BjMain {



    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;
    static int result=Integer.MAX_VALUE;
    static int num=1;

    static class Pair{
        int y=0;
        int x=0;
        public Pair(int y,int x){
            this.y=y;
            this.x=x;
        }
    }

    static int Pointer(int p){
        int d=0;
        if(p>0){
            d = 1;
        }
        else if(p<0){
            d = -1;
        }
        else{
            d = 0;
        }

        return d;
    }


    static void logic()throws IOException{
        int N = Integer.parseInt(br.readLine());
        int m[][] = new int[N][N];
        Pair[] p = new Pair[12];
        int size=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
                if(m[i][j]!=0){
                    int temp = m[i][j]-1;
                    p[temp] = new Pair(i,j);
                    size++;
                }
            }
        }

        int count=0;
        int turn=0;
        int py=0,px=0,dir=1; //0 위 //1 왼 //2 아래 //3 오
        //실행
        while (true){
            if(count==size){
                System.out.println("#"+(num++)+" "+turn);
                break;
            }

            int d = 0;
            int P = 0;
            //방향
            if(dir==0){
                int x = p[count].x  - px;
                d = Pointer(x);
            }
            else if(dir==1){
                int y = p[count].y - py;
                d = Pointer(y);
            }
            else if(dir==2){
                int x = px - p[count].x ;
                d = Pointer(x);
            }
            else{
                int y = py - p[count].y ;
                d = Pointer(y);
            }

            if(dir==0){
                int y =  py- p[count].y ;
                P = Pointer(y);
            }
            else if(dir==1){
                int x = p[count].x - px;
                P= Pointer(x);
            }
            else if(dir==2){
                int y = p[count].y - py ;
                P = Pointer(y);
            }
            else{
                int x =px - p[count].x;
                P= Pointer(x);
            }

            if(d==1 && P>=0){
                turn++;
                dir++;
            }
            else if(d==1 && P==-1){
                turn+=2;
                dir+=2;

            }
            else if((d==0 && P==-1)||( d==-1)){
                turn+=3;
                dir+=3;
            }

            py=p[count].y;
            px=p[count].x;
            dir%=4;
            count++;
        }
    }



    public static void main(String[] args)throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            logic();
        }
    }

}
