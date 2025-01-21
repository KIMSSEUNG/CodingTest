import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//    D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//    L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//    R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//    S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

    //    .	평지(전차가 들어갈 수 있다.)
    //*	벽돌로 만들어진 벽
    //#	강철로 만들어진 벽
    //-	물(전차는 들어갈 수 없다.)
    //^	위쪽을 바라보는 전차(아래는 평지이다.)
    //    v	아래쪽을 바라보는 전차(아래는 평지이다.)
    //    <	왼쪽을 바라보는 전차(아래는 평지이다.)
    //>	오른쪽을 바라보는 전차(아래는 평지이다.)
    static char[][] m = new char[23][23];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static int h=0,w=0;
    static int py=0 ,px=0;
    static int num =1;
    static void action_go(char s , int y , int x ){
        int ny=0,nx=0;
        if(s=='U'){
            ny = y+dy[0];
            nx = x+dx[0];
            if(ny<0||ny>=h||nx<0||nx>=w || m[ny][nx]!='.'){
                m[y][x] = '^';
                return;
            }
            m[ny][nx] = '^';
            py=ny;px=nx;
            m[y][x] = '.';
        }
        else if(s=='D'){
            ny = y+dy[2];
            nx = x+dx[2];
            if(ny<0||ny>=h||nx<0||nx>=w || m[ny][nx]!='.'){
                m[y][x] = 'v';
                return;
            }
            m[ny][nx] = 'v';
            py=ny;px=nx;
            m[y][x] = '.';
        }
        else if(s=='R'){
            ny = y+dy[1];
            nx = x+dx[1];
            if(ny<0||ny>=h||nx<0||nx>=w || m[ny][nx]!='.'){
                m[y][x] = '>';
                return;
            }
            m[ny][nx] = '>';
            py=ny;px=nx;
            m[y][x] = '.';
        }
        else{
            ny = y+dy[3];
            nx = x+dx[3];
            if(ny<0||ny>=h||nx<0||nx>=w || m[ny][nx]!='.'){
                m[y][x] = '<';
                return;
            }
            m[ny][nx] = '<';
            py=ny;px=nx;
            m[y][x] = '.';
        }
    }

    static void action_shoot(char s , int y , int x ){
        int ny=0,nx=0;
        if(s=='^'){
            while (true){
                ny = y+dy[0];
                nx = x+dx[0];
                if(ny<0||ny>=h||nx<0||nx>=w){
                    break;
                }
                if(m[ny][nx]=='*'){
                    m[ny][nx]='.';
                    break;
                }
                if(m[ny][nx]=='#'){
                    break;
                }
                y=ny;x=nx;
            }
        }
        else if(s=='v'){
            while (true){
                ny = y+dy[2];
                nx = x+dx[2];
                if(ny<0||ny>=h||nx<0||nx>=w){
                    break;
                }
                if(m[ny][nx]=='*'){
                    m[ny][nx]='.';
                    break;
                }
                if(m[ny][nx]=='#'){
                    break;
                }
                y=ny;x=nx;
            }
        }
        else if(s=='>'){
            while (true){
                ny = y+dy[1];
                nx = x+dx[1];
                if(ny<0||ny>=h||nx<0||nx>=w){
                    break;
                }
                if(m[ny][nx]=='*'){
                    m[ny][nx]='.';
                    break;
                }
                if(m[ny][nx]=='#'){
                    break;
                }
                y=ny;x=nx;
            }
        }
        else{
            while (true){
                ny = y+dy[3];
                nx = x+dx[3];
                if(ny<0||ny>=h||nx<0||nx>=w){
                    break;
                }
                if(m[ny][nx]=='*'){
                    m[ny][nx]='.';
                    break;
                }
                if(m[ny][nx]=='#'){
                    break;
                }
                y=ny;x=nx;
            }
        }

    }

    static void logic() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        //초기화
        for(int i=0;i<m.length;i++){
            Arrays.fill(m[i],' ');
        }

        //셋
        for(int i=0;i<h;i++){
            String temp = br.readLine();
            for(int j=0;j<temp.length();j++){
                m[i][j] = temp.charAt(j);
                if(m[i][j]=='^' || m[i][j]=='v' || m[i][j]=='<' || m[i][j]=='>'){
                    py=i;px=j;
                }
            }
        }
        //go
        String s = br.readLine();
        char[] in = br.readLine().toCharArray();
        for(int i=0;i<in.length;i++){
            if(in[i]=='S'){
                action_shoot(m[py][px] ,py,px);
            }
            else{
                action_go(in[i] ,py,px);
            }


        }

        System.out.print("#"+(num++)+" ");
        for(int x=0;x<h;x++){
            for(int y=0;y<w;y++){
                System.out.print(m[x][y]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)throws IOException {
        int tC = Integer.parseInt(br.readLine());
        for(int i=0;i<tC;i++){
            logic();
        }
    }
}
