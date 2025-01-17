import java.util.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] p = new int[52];
    static int[] arr = new int[101];

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int s=j+1;s<N;s++){
                    var temp = arr[i]+arr[j]+arr[s];
                    if(temp<=M){
                        result = result>temp?result:temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}