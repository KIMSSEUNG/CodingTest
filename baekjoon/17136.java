import java.util.*;
import java.io.*;
//트러블
// 만약 y ,x 를 재귀에 넘기며 이중 for문을 실행 시킬 경우
// y는 괜찮지만 x는 해당 수를 건너 뛸 수 있음으로 주의
// 또한
// 나는 처음의 1을 찾는 경우를 재귀 함수 안에 2중 for문으로 찾았다
// 하지만 그와 같이 할 경우 시간 복잡도가 너무 커짐으로 for을 돌리는 것이 아닌
// 매개변수로써 넘겨주면서 해결했다.

public class BjMain {

    static int[][] m = new int[10][10];
    static int[][] visited = new int[10][10];
    static int N=10;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result=Integer.MAX_VALUE;
    static int[] check = {0,5,5,5,5,5};

    public static boolean check(int y, int x , int n) {
        for(int h=y;h<y+n;h++){
            for(int w=x;w<x+n;w++){
                if(h>=N || w>=N || visited[h][w]==1 || m[h][w]!=1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void attach(int y, int x ,int n , int c) {
        for(int h=y;h<y+n;h++){
            for(int w=x;w<x+n;w++){
                visited[h][w]= c;
            }
        }
    }

    public static void recursive(int y , int x  , int cnt){
        //도달 할 경우
        if(y==N-1 && x==N){
            result = Integer.min(result,cnt);
            return;
        }

        //x가 10일 경우 줄 바꾸기
        if(x>=10){
            recursive(y+1,0 , cnt);
            return;
        }

        //1이 아닐 경우나 visted 일 경우
        if(m[y][x]!=1 || visited[y][x]==1){
            recursive(y,x+1 , cnt);
            return;
        }

        //붙일 경우
        for(int i=5;i>=1;i--){
            if(check(y,x,i) && check[i]!=0){
                attach(y,x,i,1);
                check[i]--;
                recursive(y, x+1 , cnt+1);
                attach(y,x,i,0);
                check[i]++;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        StringTokenizer st ;
        boolean isFirst = false;
        int y=0 , x=0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
                if(m[i][j]==1 && !isFirst){
                    y=i;x=j; isFirst=true;
                }
            }
        }

        if(!isFirst){
            System.out.println(0);
            return;
        }

        recursive(y,x, 0);
        if(result == Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(result);
    }

}
