import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] m = new int[104][104];


    static int[] check = new int[102];
    public static void main(String[] args)throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxY = 0;
        int maxX = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            maxX = Math.max(x+11,maxX);
            int y = Integer.parseInt(st.nextToken());
            maxY = Math.max(y+11,maxY);
            for(int j=y;j<y+10;j++) {
                for (int s = x; s < x + 10; s++) {
                    m[j][s] = 1;
                }
            }
        }

        int result = 0;
        //왼쪽
        for(int i=1;i<=maxX;i++){
            int local = 0;
            for(int j=1;j<=maxY;j++){
                if(m[j][i]==1 && check[j]==0 && m[j][i-1]!=1){
                    check[j] = 9;
                    local++;
                }
                else if(check[j]!=0)check[j]--;
            }
            result+=local;
        }

        //오른쪽
        Arrays.fill(check,0);
        for(int i=maxX;i>=1;i--){
            int local = 0;
            for(int j=maxY;j>=1;j--){
                if(m[j][i]==1 && check[j]==0 && m[j][i+1]!=1){
                    //System.out.println(j+" "+i);
                    check[j] = 9;
                    local++;
                }
                else if(check[j]!=0)check[j]--;
            }
            result+=local;
        }

        //위
        Arrays.fill(check,0);
        for(int i=1;i<=maxY;i++){
            int local = 0;
            for(int j=1;j<=maxX;j++){
                if(m[i][j]==1 && check[j]==0 && m[i-1][j]!=1){
                    check[j] = 9;
                    local++;
                }
                else if(check[j]!=0)check[j]--;
            }
            result+=local;
        }

        //아래
        Arrays.fill(check,0);
        for(int i=maxY;i>=1;i--){
            int local = 0;
            for(int j=maxX;j>=1;j--){
                if(m[i][j]==1 && check[j]==0 && m[i+1][j]!=1){
                    check[j] = 9;
                    local++;
                }
                else if(check[j]!=0)check[j]--;
            }
            result+=local;
        }

        System.out.print(result);

    }
}
