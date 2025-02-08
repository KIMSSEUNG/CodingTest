import java.util.*;
import java.io.*;
// 반례
// 아웃 시 다음 칠 Point StartP로 인한 문제였다.
// 만약 out 시점에서 해주는 것이 아닌
// 1: 바깥쪽에서 해줄 경우 마지막 9번 타자 아웃 시에는 StartP를 갱신 못한다.
// 2: 바깥쪽에  if(out<3)startP=0;을 할 경우 out 되어서 StartP를 받았을 때 모두 0이 뜬다.

public class Main {

    static int[][] m = new int[51][9];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result=0;
    static int startP=0;
    static int N=0;

    static int stage(int[] player){
        int out=0;
        boolean[] st = new boolean[3];
        int local=0;
        while (out!=3){
            for(int i=startP;i<player.length;i++){
                int c = player[i];
                if(c==0){
                    out++;
                    if(out==3){
                        startP = (i+1)%9;
                        break;
                    }
                }
                else if(c==1){
                    if(st[2]==true){
                        local++;st[2]=false;
                    }
                    if(st[1]==true){
                        st[1]=false;st[2]=true;
                    }
                    if(st[0]==true){
                        st[0]=false;st[1]=true;
                    }
                    st[0]=true;
                }
                else if(c==2){
                    if(st[2]==true){
                        local++;st[2]=false;
                    }
                    if(st[1]==true){
                        local++;st[1]=false;
                    }
                    if(st[0]==true){
                        st[0]=false;st[2]=true;
                    }
                    st[1]=true;
                }
                else if(c==3){
                    if(st[2]==true){
                        local++;st[2]=false;
                    }
                    if(st[1]==true){
                        local++;st[1]=false;
                    }
                    if(st[0]==true){
                        local++;st[0]=false;
                    }
                    st[2]=true;
                }
                else{
                    if(st[2]==true){
                        local++;st[2]=false;
                    }
                    if(st[1]==true){
                        local++;st[1]=false;
                    }
                    if(st[0]==true){
                        local++;st[0]=false;
                    }
                    local++;
                }
            }
            if(out<3)startP=0;
        }

        return local;
    }

    static int Calcu(int[] s){
        int local=0;
        startP=0;
        for(int w=0;w<N;w++){
            //설정
            int[] player = new int[9];
            player[3] =m[w][0];
            for(int i=0,j=-1;i<9;i++,j++){
                if(i<3){
                    player[i] =m[w][s[i]];
                }
                else if(i>3){
                    player[i] =  m[w][s[j]];
                }
            }
            //경기
            local+=stage(player);
        }
        return local;
    }

    public static void recursive(int[] storage ,int k  , boolean[] visit ){
        if(k==8){
            //Calcu
            result = Integer.max(Calcu(storage),result);
            return;
        }

        for(int i=1;i<storage.length;i++){
            if(!visit[i]){
                visit[i] = true;
                storage[k] = i;
                recursive(storage,k+1 , visit );
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(new int[9] , 0 ,new boolean[9] );
        System.out.println(result);
    }

}
