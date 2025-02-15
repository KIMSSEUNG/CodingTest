import java.util.*;
import java.io.*;

public class BjMain {

    static class Pair{
        int y;
        int x;
        int e;
        int height;
        public Pair(int y, int x , int e,int height) {
            this.y =y;
            this.x =x;
            this.e = e;
            this.height= height;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int result=Integer.MAX_VALUE;
    static int num=1;
    static int[][] dp = new int[31][31];

    static void recursive(int y , int x , int[][] m, int[][] visit , int h ,int res){
        int N = m.length;

        if(y==N-1 && x==N-1){
            result = Integer.min(res , result);
            return;
        }
        if(dp[y][x] <= res)return;
        dp[y][x]=res;
        for(int i=0;i<4;i++){
            int ny =y+dy[i];
            int nx =x+dx[i];
            if(ny<0||ny>=N||nx<0||nx>=N|| visit[ny][nx]==1)continue;
            //조건 추가

            visit[ny][nx]=1;
            if(h>m[ny][nx]){
                recursive(ny,nx,m,visit,m[ny][nx],res);
            }
            else if(h<m[ny][nx]){
                recursive(ny,nx,m,visit,m[ny][nx],res+( (m[ny][nx]-h) * 2 ));
            }
            else{
                recursive(ny,nx,m,visit,m[ny][nx],res+1);
            }
            visit[ny][nx]=0;
        }
    }


    static void logic()throws IOException{
        int N = Integer.parseInt(br.readLine());
        int m[][] = new int[N][N];
        int visit[][] = new int[N][N];
        //초기화
        result=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println("실행");
        visit[0][0]=1;
        recursive(0,0,m , visit,m[0][0] , 0);
        System.out.println("#"+(num++)+" "+result);

    }



    public static void main(String[] args)throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            logic();
        }
    }

}
