import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] arr = new char[101][101];

    public static void main(String[] args)throws IOException {

        String in = br.readLine();
        int size = in.length();
        int R=0 , C=0;
        for(int i=1;i<=size;i++){
            if(size%i!=0) continue;

            int rTemp = i;
            int cTemp =size/i;
            if(rTemp>cTemp) continue;
            R = rTemp; C=cTemp;
        }
        char[] temp = in.toCharArray();
        for(int i=0;i<R;i++){
            for(int j=i*C;j<(i*C)+C;j++){
                arr[i][j-(i*C)] = temp[j];
            }
        }

        for(int i=0;i<C;i++){
            for(int j=i*R;j<(i*R)+R;j++){
                arr[j-(i*R)][i] = temp[j];
            }
        }
        String result ="";
        for(int i=0;i<R;i++){
            String temp2 = "";
            for(int j=0;j<C;j++){
                temp2+=arr[i][j];
            }
            result+=temp2;
        }
        System.out.println(result);
    }
}