import java.util.*;
import java.io.*;
//1차 반례
//6목 에러
//2차 반례
//6목과 5목 겹칠 경우 5목을 정답 인정 못함
//3차 반례
//y-- x++의 경우 6목을 정답으로 허용
public class Main {
    static class pair{
        public int y=0;
        public int x=0;
        public pair(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[19][19];
    static int[][] visit_x = new int[19][19];
    static int[][] visit_y = new int[19][19];
    static int[][] visit_z = new int[19][19];
    static int[][] visit_z2 = new int[19][19];

    static int check(int c , int n , int i , int j) {
        //가로업
        int localResult = 0;
        List<pair> l =new ArrayList<>();
        for(int s=j;s<n;s++) {
            if(map[i][s]==c && visit_x[i][s]==0) {
                localResult++;
                l.add(new pair(i,s));
            }
            else{
                break;
            }
        }
        if(localResult==5) {
            return c;
        }
        else if(localResult>5){
            for(int s=0;s<l.size();s++){
                pair pair = l.get(s);
                visit_x[pair.y][pair.x]=1;
            }
        }
        l.clear();
        localResult=0;

        //세로업
        for(int s=i;s<n;s++) {
            if(map[s][j]==c && visit_y[s][j]==0){
                localResult++;
                l.add(new pair(s,j));
            }
            else{
                break;
            }
        }
        if(localResult==5) {
            return c;
        }
        else if(localResult>5){
            for(int s=0;s<l.size();s++){
                pair pair = l.get(s);
                visit_y[pair.y][pair.x]=1;
            }
        }
        l.clear();
        localResult=0;

        //대각 -2
        for(int y=i , x= j;y>=0 && x<n;y--,x++) {
            if(map[y][x]==c && visit_z2[y][x]==0){
                localResult++;
                l.add(new pair(y,x));
            }
            else{
                break;
            }
        }
        if(localResult==5) {
            if(i+1<n && j-1>=0){
                if(map[i+1][j-1]!=c)return c;
            }
            else{
                return c;
            }
        }
        else if(localResult>5){
            for(int s=0;s<l.size();s++){
                pair pair = l.get(s);
                visit_z2[pair.y][pair.x]=1;
            }
        }
        l.clear();
        localResult=0;
        //대각 -4
        for(int y=i , x= j;y<n && x<n;y++,x++) {
            if(map[y][x]==c && visit_z[y][x]==0) {
                localResult++;
                l.add(new pair(y,x));
            }
            else{
                break;
            }
        }

        if(localResult==5) {
            return c;
        }
        else if(localResult>5){
            for(int s=0;s<l.size();s++){
                pair pair = l.get(s);
                visit_z[pair.y][pair.x]=1;
            }
        }

        return 0;
    }

    public static void main(String[] args)throws IOException {
        int n =19;
        for(int i=0;i<19;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int ry=0,rx=0;
        boolean isCheck = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]!=0) {
                    result = check(map[i][j],n,i,j);
                    if(result!=0) {
                        isCheck=true;
                        ry=i;rx=j;
                        break;
                    }
                }
            }
            if(isCheck)break;
        }
        System.out.println(result);
        if(result!=0) {
            System.out.println((++ry)+" "+(++rx));
        }
    }
}
