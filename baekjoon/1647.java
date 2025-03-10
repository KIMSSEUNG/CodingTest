import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;
    static int N=0;
    static int Max=0;
    static int m[][];

    static class pair implements Comparable<pair>{
        int e=0;
        int w=0;
        public pair(int e , int w){
            this.e =e;
            this.w =w;
        }


        @Override
        public int compareTo(pair o) {
            return Integer.compare(this.w , o.w);
        }
    }

    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<pair>[] adj = new List[N+1];
        for(int i=0;i< adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[A].add(new pair(B,w));
            adj[B].add(new pair(A,w));
        }

        int dist[] = new int[N+1];
        int visit[] = new int[N+1];
        for(int i=1;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<pair> q = new PriorityQueue<>();

        q.add(new pair(1,0));
        dist[1]=0;
        while (!q.isEmpty()){
            int minP = -1;
            while (!q.isEmpty()){
                pair p = q.poll();
                if(visit[p.e]==0){
                    minP = p.e;
                    break;
                }
            }

            if(minP==-1)break;
            visit[minP]=1;

            for(int i=0;i<adj[minP].size();i++){
                pair p = adj[minP].get(i);
                if(visit[p.e]==0 && p.w<dist[p.e]){
                    dist[p.e] = p.w;
                    q.add(new pair(p.e,p.w));
                }
            }
        }

        int Max=0;
        int res=0;
        for(int i=0;i<dist.length;i++){
            Max = Integer.max(dist[i],Max);
            res+=dist[i];
        }

        System.out.println(res-Max);
    }

}
