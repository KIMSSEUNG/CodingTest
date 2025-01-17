import java.util.*;
import java.io.*;

// 1 실패요인
// 1000개의 경우를 순열로 돌리려 했다;;
// 2 성공
// 사실상 순서는 낮은 순으로 정렬해서 계산하면 정답이다. 고로 우선순위 큐 다음 계산이다.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N =0;
    static int[] arr = new int[1004];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int calcu(){
        int result=0;
        for(int i=0;i<N;i++){
            int localValue=0;
            for(int j=0;j<=i;j++){
                localValue+=arr[j];
            }
            result+=localValue;
        }
        return result;
    }


    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int count=0;
        while (!pq.isEmpty()){
            arr[count++] = pq.poll();
        }

        System.out.println(calcu());


    }
}