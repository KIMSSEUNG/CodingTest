import javax.security.auth.kerberos.KerberosTicket;
import java.util.*;
import java.io.*;

//반례 - 최저값 설정 에러

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> arr =new ArrayList<>();
    static List<Character> iter = new ArrayList<>();
    static Long result = Long.MIN_VALUE;
    static Long cal(char iter , Long numA , Long numB){
        switch (iter){
            case '+':
                return numA+numB;
            case '*':
                return numA*numB;
            case '-':
                return numA-numB;
        }
        return 0L;
    }

    static Long calcu(boolean[] visit , int N){
        List<Long> loArr = new ArrayList<>();
        List<Character> loiter = new ArrayList<>();
        boolean[] v = new boolean[N+1];
        for(int i=0;i<visit.length;i++){
            if(!visit[i] ){
                if(!v[i])loArr.add(Long.valueOf(arr.get(i)));
                loiter.add(iter.get(i));
                if(i == visit.length-1)loArr.add(Long.valueOf(arr.get(i+1)));
            }
            else{
                loArr.add(cal( iter.get(i), Long.valueOf(arr.get(i)) , Long.valueOf(arr.get(i+1))));
                v[i] =true; v[i+1]=true;
            }
        }

        Long result = loArr.get(0);
        for(int i=0;i<loiter.size();i++){
            result=cal(loiter.get(i) , result , loArr.get(i+1));
        }

        return result;
    }

    static void recursive(boolean[] visit , int idx , int n){
        //연산
        result = Long.max(calcu(visit ,n),result);
        if(idx>=n)return;
        visit[idx]=true;
        recursive(visit,idx+2,n);
        visit[idx]=false;
        recursive(visit,idx+1,n);
    }

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String t = br.readLine();
        if(N==1){
            System.out.println(t.charAt(0)-'0');
            return;
        }

        for(int i=0;i<t.length();i++){
            if(i%2==1){
                iter.add(t.charAt(i));
            }
            else{
                arr.add(t.charAt(i)-'0');
            }
        }
        int n = t.length()/2;
        recursive(new boolean[n] , 0 , n);
        System.out.println(result);
    }
}
