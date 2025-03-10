import java.lang.reflect.Array;
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

        int Num = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[A].add(new pair(B,w));
        }

        int dist[] = new int[N+1];
        int visit[] = new int[N+1];
        for(int i=1;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(Num,0));
        dist[Num]=0;
        while (!pq.isEmpty()){
            int minP=-1;
            while (!pq.isEmpty()){
                pair p = pq.poll();
                if(visit[p.e]==0){
                    minP=p.e;
                    break;
                }
            }

            if(minP==-1)continue;
            visit[minP] =1;

            for(int i=0;i<adj[minP].size();i++){
                pair p = adj[minP].get(i);
                if(visit[p.e]==1 || (dist[minP]+p.w)>=dist[p.e])continue;
                dist[p.e] = dist[minP]+p.w;
                pq.add(new pair(p.e, dist[p.e]));
            }
        }

        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }


    }

}
