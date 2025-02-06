import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count=0;
    static StringBuffer sb = new StringBuffer();
    static int m[][] = new int[12][12];
    static int arr[] = new int[12];
    static int result = Integer.MAX_VALUE;

    //파워셀 , 인접행렬 , DFS

    static int DFS(int node , boolean visit[] , List<Integer> l){
        visit[node] = true;
        int result = 1;
        for(int i=0;i<l.size();i++){
            int P = l.get(i);
            if(visit[P] || m[node][P]!=1 )continue;
            result+=DFS(P,visit , l);
        }

        return result;
    }

    static int Calcu(boolean[] visit) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for(int i=1;i<visit.length;i++) {
            if(visit[i])A.add(i);
            else B.add(i);
        }

        if(A.size()==0 || B.size()==0)return Integer.MAX_VALUE;
        //확인
        int AC = DFS(A.get(0),new boolean[visit.length],A);
        if(AC != A.size())return Integer.MAX_VALUE;

        int BC = DFS(B.get(0),new boolean[visit.length],B);
        if(BC != B.size())return Integer.MAX_VALUE;

        //계산
        int sumA=0 , sumB=0;
        for(int i=0;i<A.size();i++) {
            sumA+=arr[A.get(i)];
        }

        for(int i=0;i<B.size();i++) {
            sumB+=arr[B.get(i)];
        }
        return Math.abs(sumA-sumB);
    }

    static void recursive( boolean[] visit , int k , int idx , int N) {
        if(k==N) {
            result = Integer.min(result,Calcu(visit));
            return;
        }

        visit[idx] = true;
        recursive(visit , k+1 , idx+1,N);
        visit[idx] = false;
        recursive(visit, k+1 , idx+1,N);

    }


    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int Nt = Integer.parseInt(st.nextToken());
            for(int j=0;j<Nt;j++) {
                int node = Integer.parseInt(st.nextToken());
                m[i][node]=1;
                m[node][i]=1;
            }
        }

        recursive(new boolean[N+1] , 0 , 1 , N);
        if(result == Integer.MAX_VALUE)System.out.println(-1);
        else System.out.println(result);
    }
}
