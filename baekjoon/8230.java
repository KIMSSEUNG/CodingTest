import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(br.readLine());
        int result= 0;

        for(int i=1;i<=n;i++){ //가로
            for(int j=i;j*i<=n;j++){ //세로
                result++;
            }
        }

        System.out.println(result);
    }
}