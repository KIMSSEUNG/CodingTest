import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] roll = new int[1002];

    public static void main(String[] args)throws IOException {
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int expec = Integer.MIN_VALUE;
        int expecNum = 0;

        int max = Integer.MIN_VALUE;
        int maxNum = 0;

        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            //기대
            if(k-p>expec){
                expec= k-p;
                expecNum=i;
            }
            //결과
            int count=0;
            for(int j =p;j<=k;j++){
                if(roll[j]==1)
                    continue;
                count++;
                roll[j]=1;
            }

            if(count>max){
                max = count;
                maxNum = i;
            }
        }
        System.out.println(expecNum);
        System.out.println(maxNum);

    }
}