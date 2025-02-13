import java.util.*;
import java.io.*;

public class BjMain {

    static class three{
        int y;
        int x;
        int c;
        public three(int y, int x , int c) {
            this.y =y;
            this.x =x;
            this.c= c;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;
    static three[] check;
    static int m[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {1,0,-1,0};
    static int N=0 , M=0 , K=0;
    static int res = Integer.MAX_VALUE;

    static int suffle(int[] storage) {

        int[][] tempM = new int[N][M];

        for(int i=0;i<m.length;i++) {
            for(int j=0;j<m[0].length;j++) {
                tempM[i][j] = m[i][j];
            }
        }

        for(int i=0;i<storage.length;i++) {
            three t =  check[storage[i]];
            int count=1;
            while(count<t.c+1) {
                int ly = t.y-count ,lx = t.x-count;
                int ry = t.y+count ,rx = t.x+count;

                if(ly<0|| ly>=N || lx<0 || lx>=M)break;
                if(ry<0|| ry>=N || rx<0 || rx>=M)break;

                int py = ly;
                int px = lx;
                int p = 0;
                int temp=tempM[py][px];
                while(true) {
                    int ny = py + dy[p];
                    int nx = px + dx[p];
                    if(nx>rx || ny>ry || nx<lx) {
                        p++;
                        continue;
                    }
                    if(ny<ly) {
                        break;
                    }

                    int store =  tempM[ny][nx];
                    tempM[ny][nx] = temp; //이전값
                    temp = store;
                    py = ny;
                    px = nx;
                }
                count++;
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<tempM.length;i++) {
            int sum=0;
            for(int j=0;j<tempM[0].length;j++) {
                sum+=tempM[i][j];
            }
            result = Integer.min(sum, result);
        }
        return result;
    }

    static void recursive( int k , boolean[] v , int[] storage) {
        if(k==K) {
            res = Integer.min(suffle(storage),res);
            return;
        }

        for(int i=0;i<v.length;i++) {
            if(v[i])continue;

            storage[k] = i;
            v[i] = true;
            recursive(k+1,v,storage);
            v[i] = false;

        }

    }


    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        m = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new three[K];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            y--;
            int x = Integer.parseInt(st.nextToken());
            x--;
            int c  = Integer.parseInt(st.nextToken());
            check[i] = new three(y,x,c);
        }

        recursive(0,new boolean[K] , new int[K]);
        System.out.println(res);


    }

}
