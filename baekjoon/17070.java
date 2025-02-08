import java.util.*;
import java.io.*;


public class BjMain {

    static int[][] m = new int[18][18];
    static int[][] visited = new int[18][18];
    static int N=0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result=0;

    static void DFS(int y , int x , int dir){



        //체크 해당 하는 지점
        if((dir==0 || dir==1)&&(m[y][x]==1)){
            return;
        }
        if( dir==2&&(m[y][x]==1 || m[y][x-1]==1 || m[y-1][x]==1) ){
            return;
        }
        if(y==N-1 && x==N-1){
            result++;
            return;
        }
        //로직
        if(dir==0){
            if(x+1<N && visited[y][x+1]==0){
                visited[y][x+1]=1;
                DFS(y,x+1,0);
                visited[y][x+1]=0;
            }
            if((x+1<N && y+1<N)&&visited[y+1][x+1]==0){
                visited[y+1][x+1]=1;
                DFS(y+1,x+1,2);
                visited[y+1][x+1]=0;
            }
        }
        else if(dir==1){
            if(y+1<N && visited[y+1][x]==0){
                visited[y+1][x]=1;
                DFS(y+1,x,1);
                visited[y+1][x]=0;
            }
            if((x+1<N && y+1<N)&&visited[y+1][x+1]==0){
                visited[y+1][x+1]=1;
                DFS(y+1,x+1,2);
                visited[y+1][x+1]=0;
            }
        }
        else{
            if(y+1<N && visited[y+1][x]==0){
                visited[y+1][x]=1;
                DFS(y+1,x,1);
                visited[y+1][x]=0;
            }
            if((x+1<N && y+1<N)&&visited[y+1][x+1]==0){
                visited[y+1][x+1]=1;
                DFS(y+1,x+1,2);
                visited[y+1][x+1]=0;
            }
            if(x+1<N && visited[y][x+1]==0){
                visited[y][x+1]=1;
                DFS(y,x+1,0);
                visited[y][x+1]=0;
            }
        }

    }

    public static void main(String[] args)throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0]=1;
        visited[0][1]=1;
        DFS(0,1 , 0);
        System.out.println(result);
    }

}
