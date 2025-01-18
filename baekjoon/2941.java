import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] roll = new int[1002];
    static List<String> m = new ArrayList<>();
    static int[] visit = new int[101];
    static void set(){
        m.add("c=");
        m.add("c-");
        m.add("dz=");
        m.add("d-");
        m.add("lj");
        m.add("nj");
        m.add("s=");
        m.add("z=");
    }

    public static void main(String[] args)throws IOException {
        String in = br.readLine();
        char[] chr = in.toCharArray();
        set();
        List<String> l = new ArrayList<>();
        for(int i=0;i<chr.length;i++){
            String temp ="";
            if(visit[i]==1)
                continue;
            for(int j=i;j<chr.length;j++){
                temp+=chr[j];
                for(int s=0;s<m.size();s++){
                    if(!m.contains(temp))continue;
                    l.add(temp);
                    for(int x = i ; x<=j;x++){
                        visit[x]=1;
                    }
                    break;
                }
            }
        }
        int result = 0;
        int length = 0;
        for(int i=0;i<l.size();i++){
            result++;
            length+=l.get(i).length();
        }
        result += in.length() - length;
        System.out.println(result);
    }
}