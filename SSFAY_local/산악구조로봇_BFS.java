import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.*;
import java.io.*;

public class Main {

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

    static void logic()throws IOException{
        int N = Integer.parseInt(br.readLine());
        int m[][] = new int[N][N];
        int visit[][] = new int[N][N];
        //초기화
        result=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            Arrays.fill(visit[i],Integer.MAX_VALUE);
        }


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0,m[0][0]));
        visit[0][0]=Integer.MAX_VALUE;
        while (!q.isEmpty()){
            Pair p =q.poll();
            if(p.y==N-1 && p.x==N-1){
                result = Integer.min(p.e,result);
                continue;
            }
            if(p.e >= visit[p.y][p.x])continue;
            visit[p.y][p.x] = p.e;
            for(int i=0;i<4;i++){
                int ny =p.y+dy[i];
                int nx =p.x+dx[i];
                if(ny<0||ny>=N||nx<0||nx>=N)continue;
                //조건 추가
                if(p.height>m[ny][nx]){
                    q.add(new Pair(ny,nx,p.e,m[ny][nx]));
                }
                else if(p.height<m[ny][nx]){
                    q.add(new Pair(ny,nx,p.e+ ((m[ny][nx]-p.height) * 2 ),m[ny][nx]));
                }
                else{
                    q.add(new Pair(ny,nx,p.e+ 1 ,m[ny][nx]));
                }
            }
        }

        System.out.println("#"+(num++)+" "+result);

    }



    public static void main(String[] args)throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            logic();
        }
    }

}
