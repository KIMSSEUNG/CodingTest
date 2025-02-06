import java.util.*;
import java.io.*;

public class Main {
    //모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
    //정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
    static class Pair{
        int h=0;
        int y=0;
        int x=0;
        public Pair(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] m = new int[101][101][101];
    static int[][][] visit = new int[101][101][101];
    static int M , N , H;
    //BFS 문제

    static int[] dh = {0,0,0,0,1,-1};
    static int[] dy = {-1,0,1,0,0,0};
    static int[] dx = {0,1,0,-1,0,0};

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Queue<Pair> tempQ = new LinkedList<>();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int s=0;s<M;s++){
                    m[i][j][s] = Integer.parseInt(st.nextToken());
                    if(m[i][j][s]==1){
                        tempQ.add(new Pair(i,j,s));
                        visit[i][j][s]=1;
                    }
                }
            }
        }

        int result=0;
        while (true){
            Queue<Pair> q = new LinkedList<>();
            while (tempQ.size()!=0) q.add(tempQ.poll());
            while (q.size()!=0){
                Pair p = q.poll();
                for(int i=0;i<6;i++){
                    int nh = p.h+dh[i];
                    int ny = p.y+dy[i];
                    int nx = p.x+dx[i];
                    if(ny<0||ny>=N||nx<0||nx>=M)continue;
                    if(nh<0||nh>=H)continue;
                    if(visit[nh][ny][nx]==1 || m[nh][ny][nx]==1 || m[nh][ny][nx]==-1)continue;
                    tempQ.add(new Pair(nh,ny,nx));
                    visit[nh][ny][nx]=1;
                    m[nh][ny][nx]=1;
                }
            }
            if(tempQ.size()==0)break;
            result++;
        }

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int s=0;s<M;s++){
                    if(m[i][j][s]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void print(){
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int s=0;s<M;s++){
                    System.out.print(m[i][j][s]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("##############");
    }
}
